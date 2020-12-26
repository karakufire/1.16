package cofh.core.xp;

import cofh.core.util.IResourceStorage;
import cofh.core.util.helpers.MathHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.util.INBTSerializable;

import static cofh.core.util.constants.Constants.MAX_CAPACITY;
import static cofh.core.util.constants.NBTTags.TAG_XP;
import static cofh.core.util.constants.NBTTags.TAG_XP_MAX;

/**
 * Implementation of an Experience Storage object. See {@link IXpStorage}.
 *
 * @author King Lemming
 */
public class XpStorage implements IXpStorage, IResourceStorage, INBTSerializable<CompoundNBT> {

    protected final int baseCapacity;

    protected int xp;
    protected int capacity;

    public XpStorage(int capacity) {

        this(capacity, 0);
    }

    public XpStorage(int capacity, int xp) {

        this.baseCapacity = capacity;

        this.capacity = capacity;
        this.xp = Math.max(0, Math.min(capacity, xp));
    }

    public XpStorage applyModifiers(float storageMod) {

        setCapacity(Math.round(baseCapacity * storageMod));
        return this;
    }

    public XpStorage setCapacity(int capacity) {

        this.capacity = MathHelper.clamp(capacity, 0, MAX_CAPACITY);
        this.xp = Math.max(0, Math.min(capacity, xp));
        return this;
    }

    public void setXpStored(int amount) {

        xp = amount;
        xp = Math.max(0, Math.min(capacity, xp));
    }

    // region NETWORK
    public void readFromBuffer(PacketBuffer buffer) {

        setCapacity(buffer.readInt());
        setXpStored(buffer.readInt());
    }

    public void writeToBuffer(PacketBuffer buffer) {

        buffer.writeInt(getMaxXpStored());
        buffer.writeInt(getXpStored());
    }
    // endregion

    // region NBT
    public XpStorage read(CompoundNBT nbt) {

        this.xp = nbt.getInt(TAG_XP);
        if (xp > capacity) {
            xp = capacity;
        }
        return this;
    }

    public CompoundNBT write(CompoundNBT nbt) {

        if (this.capacity <= 0) {
            return nbt;
        }
        nbt.putInt(TAG_XP, xp);
        return nbt;
    }

    public CompoundNBT writeWithParams(CompoundNBT nbt) {

        if (this.capacity <= 0) {
            return nbt;
        }
        nbt.putInt(TAG_XP, xp);
        nbt.putInt(TAG_XP_MAX, baseCapacity);
        return nbt;
    }

    @Override
    public CompoundNBT serializeNBT() {

        return write(new CompoundNBT());
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {

        read(nbt);
    }
    // endregion

    // region IXpStorage
    @Override
    public int receiveXp(int maxReceive, boolean simulate) {

        int energyReceived = Math.min(capacity - xp, maxReceive);
        if (!simulate) {
            xp += energyReceived;
        }
        return energyReceived;
    }

    @Override
    public int extractXp(int maxExtract, boolean simulate) {

        int energyExtracted = Math.min(xp, maxExtract);
        if (!simulate) {
            xp -= energyExtracted;
        }
        return energyExtracted;
    }

    @Override
    public int getXpStored() {

        return xp;
    }

    @Override
    public int getMaxXpStored() {

        return capacity;
    }
    // endregion

    // region IResourceStorage
    @Override
    public void modify(int amount) {

        xp += amount;
        if (xp > capacity) {
            xp = capacity;
        } else if (xp < 0) {
            xp = 0;
        }
    }

    @Override
    public boolean isEmpty() {

        return xp <= 0 && capacity > 0;
    }

    @Override
    public int getCapacity() {

        return getMaxXpStored();
    }

    @Override
    public int getStored() {

        return getXpStored();
    }

    @Override
    public String getUnit() {

        return "XP";
    }
    // endregion
}
