package cofh.thermal.core.util.recipes.internal;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class BaseDynamoFuel implements IDynamoFuel {

    protected final List<ItemStack> inputItems = new ArrayList<>();
    protected final List<FluidStack> inputFluids = new ArrayList<>();

    protected final int energy;

    protected final int minPower;
    protected final int maxPower;

    public BaseDynamoFuel(int energy, int minPower, int maxPower) {

        this.energy = energy;
        this.minPower = minPower;
        this.maxPower = maxPower <= 0 ? energy : maxPower;
    }

    public BaseDynamoFuel(int energy, int minPower, int maxPower, @Nullable List<ItemStack> inputItems, @Nullable List<FluidStack> inputFluids) {

        this(energy, minPower, maxPower);

        if (inputItems != null) {
            this.inputItems.addAll(inputItems);
        }
        if (inputFluids != null) {
            this.inputFluids.addAll(inputFluids);
        }
        trim();
    }

    private void trim() {

        ((ArrayList<ItemStack>) this.inputItems).trimToSize();
        ((ArrayList<FluidStack>) this.inputFluids).trimToSize();
    }

    // region IDynamoFuel
    @Override
    public List<ItemStack> getInputItems() {

        return inputItems;
    }

    @Override
    public List<FluidStack> getInputFluids() {

        return inputFluids;
    }

    @Override
    public int getEnergy() {

        return energy;
    }
    // endregion
}
