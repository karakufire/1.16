package cofh.lib.util.filter;

import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.fluids.FluidStack;

import java.util.function.Predicate;

public interface IFilter extends IFilterOptions, INBTSerializable<CompoundNBT>, INamedContainerProvider {

    Predicate<ItemStack> ALWAYS_ALLOW_ITEM = (stack) -> true;
    Predicate<FluidStack> ALWAYS_ALLOW_FLUID = (stack) -> true;

    default Predicate<ItemStack> getItemRules() {

        return ALWAYS_ALLOW_ITEM;
    }

    default Predicate<FluidStack> getFluidRules() {

        return ALWAYS_ALLOW_FLUID;
    }

    IFilter read(CompoundNBT nbt);

    CompoundNBT write(CompoundNBT nbt);

    @Override
    default CompoundNBT serializeNBT() {

        return write(new CompoundNBT());
    }

    @Override
    default void deserializeNBT(CompoundNBT nbt) {

        read(nbt);
    }

}
