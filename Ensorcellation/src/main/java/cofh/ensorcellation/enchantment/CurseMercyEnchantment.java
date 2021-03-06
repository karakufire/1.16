package cofh.ensorcellation.enchantment;

import cofh.core.enchantment.EnchantmentCoFH;
import cofh.core.init.CoreEnchantments;
import net.minecraft.inventory.EquipmentSlotType;

public class CurseMercyEnchantment extends EnchantmentCoFH {

    public CurseMercyEnchantment() {

        super(Rarity.VERY_RARE, CoreEnchantments.Types.SWORD_OR_AXE, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
        treasure = true;
    }

    @Override
    public int getMinEnchantability(int level) {

        return 25;
    }

    @Override
    protected int maxDelegate(int level) {

        return 50;
    }

    @Override
    public boolean isCurse() {

        return true;
    }

}
