package cofh.thermal.cultivation.tileentity;

import cofh.core.energy.EnergyStorageCoFH;
import cofh.core.inventory.ItemStorageCoFH;
import cofh.core.util.helpers.EnergyHelper;
import cofh.thermal.core.block.SoilBlock;
import cofh.thermal.core.tileentity.ThermalTileBase;
import cofh.thermal.cultivation.inventory.container.device.DeviceSoilInfuserContainer;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.energy.CapabilityEnergy;

import javax.annotation.Nullable;
import java.util.Map;

import static cofh.core.util.StorageGroup.INTERNAL;
import static cofh.core.util.constants.NBTTags.*;
import static cofh.thermal.core.common.ThermalConfig.deviceAugments;
import static cofh.thermal.cultivation.init.TCulReferences.DEVICE_SOIL_INFUSER_TILE;

public class DeviceSoilInfuserTile extends ThermalTileBase implements ITickableTileEntity {

    protected static final int BASE_PROCESS_MAX = 4000;

    protected ItemStorageCoFH chargeSlot = new ItemStorageCoFH(1, EnergyHelper::hasEnergyHandlerCap);

    public int radius = 1;

    protected int process;
    protected int processMax = BASE_PROCESS_MAX * radius * radius;
    protected int processTick = getBaseProcessTick() / 4 * radius;

    public DeviceSoilInfuserTile() {

        super(DEVICE_SOIL_INFUSER_TILE);
        energyStorage = new EnergyStorageCoFH(getBaseEnergyStorage(), getBaseEnergyXfer());

        inventory.addSlot(chargeSlot, INTERNAL);

        addAugmentSlots(deviceAugments);
        initHandlers();
    }

    @Override
    public void tick() {

        boolean curActive = isActive;
        if (isActive) {
            if (energyStorage.getEnergyStored() >= processTick) {
                process += processTick;
                energyStorage.modify(-processTick);
                if (process >= processMax) {
                    process -= processMax;
                    BlockPos.getAllInBox(pos.add(-radius, -1, -radius), pos.add(radius, 1, radius))
                            .forEach(this::chargeSoil);
                }
            } else {
                processOff();
            }
        } else if (redstoneControl.getState() && energyStorage.getEnergyStored() >= processTick) {
            isActive = true;
        }
        updateActiveState(curActive);
        chargeEnergy();
    }

    protected void chargeSoil(BlockPos blockPos) {

        BlockState state = world.getBlockState(blockPos);
        if (state.getBlock() instanceof SoilBlock) {
            SoilBlock.charge(state, world, blockPos);
        }
    }

    protected void chargeEnergy() {

        if (!chargeSlot.isEmpty()) {
            chargeSlot.getItemStack()
                    .getCapability(CapabilityEnergy.ENERGY, null)
                    .ifPresent(c -> energyStorage.receiveEnergy(c.extractEnergy(Math.min(energyStorage.getMaxReceive(), energyStorage.getSpace()), false), false));
        }
    }

    protected void processOff() {

        // This intentionally does not clear the process value.
        isActive = false;
        wasActive = true;
        if (world != null) {
            timeTracker.markTime(world);
        }
    }

    @Nullable
    @Override
    public Container createMenu(int i, PlayerInventory inventory, PlayerEntity player) {

        return new DeviceSoilInfuserContainer(i, world, pos, inventory, player);
    }

    // region GUI
    @Override
    public int getCurSpeed() {

        return isActive ? processTick : 0;
    }

    @Override
    public int getScaledProgress(int scale) {

        if (!isActive || processMax <= 0 || process <= 0) {
            return 0;
        }
        return scale * Math.min(process, processMax) / processMax;
    }
    // endregion

    // region NETWORK
    @Override
    public PacketBuffer getGuiPacket(PacketBuffer buffer) {

        super.getGuiPacket(buffer);

        buffer.writeInt(process);
        buffer.writeInt(processMax);
        buffer.writeInt(processTick);

        return buffer;
    }

    @Override
    public void handleGuiPacket(PacketBuffer buffer) {

        super.handleGuiPacket(buffer);

        process = buffer.readInt();
        processMax = buffer.readInt();
        processTick = buffer.readInt();
    }
    // endregion

    // region NBT
    @Override
    public void read(BlockState state, CompoundNBT nbt) {

        super.read(state, nbt);

        process = nbt.getInt(TAG_PROCESS);
        processMax = nbt.getInt(TAG_PROCESS_MAX);
        processTick = nbt.getInt(TAG_PROCESS_TICK);
    }

    @Override
    public CompoundNBT write(CompoundNBT nbt) {

        super.write(nbt);

        nbt.putInt(TAG_PROCESS, process);
        nbt.putInt(TAG_PROCESS_MAX, processMax);
        nbt.putInt(TAG_PROCESS_TICK, processTick);

        return nbt;
    }
    // endregion

    // region AUGMENTS
    @Override
    protected void resetAttributes() {

        super.resetAttributes();

        radius = 1;
    }

    @Override
    protected void setAttributesFromAugment(CompoundNBT augmentData) {

        super.setAttributesFromAugment(augmentData);

        radius += getAttributeMod(augmentData, TAG_AUGMENT_AREA_RADIUS);
    }

    @Override
    protected void finalizeAttributes(Map<Enchantment, Integer> enchantmentMap) {

        super.finalizeAttributes(enchantmentMap);

        processMax = BASE_PROCESS_MAX * (1 + radius);
        processTick = Math.round(getBaseProcessTick() * baseMod);
    }
    // endregion
}
