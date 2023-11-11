package liraaa;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class multitool implements ToolMaterial {
    public static final multitool tool = new multitool();
    @Override
    public int getDurability() {
        return 10000000;
    }
    public float getMiningSpeedMultiplier() {
        return 5000.0F;
    }
    public float getAttackDamage() {
        return 5000.0F;
    }
    public int getMiningLevel() {
        return 3;
    }
    public int getEnchantability() {
        return 15000;
    }
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.DIRT);
    }

}
