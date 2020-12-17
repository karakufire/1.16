package cofh.thermal.expansion.util.recipes.dynamo;

import cofh.thermal.core.util.recipes.ThermalFuel;
import cofh.thermal.expansion.init.TExpRecipeTypes;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

import static cofh.core.util.constants.Constants.MAX_POWER;
import static cofh.thermal.core.ThermalCore.RECIPE_SERIALIZERS;
import static cofh.thermal.expansion.init.TExpRecipeTypes.ID_FUEL_NUMISMATIC;

public class NumismaticFuel extends ThermalFuel {

    public NumismaticFuel(ResourceLocation recipeId, int energy, @Nullable List<Ingredient> inputItems, @Nullable List<FluidStack> inputFluids) {

        this(recipeId, energy, MAX_POWER, inputItems, inputFluids);
    }

    public NumismaticFuel(ResourceLocation recipeId, int energy, int power, @Nullable List<Ingredient> inputItems, @Nullable List<FluidStack> inputFluids) {

        super(recipeId, energy, power, inputItems, inputFluids);
    }

    @Nonnull
    @Override
    public IRecipeSerializer<?> getSerializer() {

        return RECIPE_SERIALIZERS.get(ID_FUEL_NUMISMATIC);
    }

    @Nonnull
    @Override
    public IRecipeType<?> getType() {

        return TExpRecipeTypes.FUEL_NUMISMATIC;
    }

    //    @Nonnull
    //    @Override
    //    public String getGroup() {
    //
    //        return DYNAMO_NUMISMATIC_BLOCK.getTranslationKey();
    //    }
    //
    //    @Nonnull
    //    @Override
    //    public ItemStack getIcon() {
    //
    //        return new ItemStack(DYNAMO_NUMISMATIC_BLOCK);
    //    }

}
