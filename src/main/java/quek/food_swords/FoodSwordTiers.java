package quek.food_swords;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum FoodSwordTiers implements IItemTier {
    MELON(71, 1.0F, 0.0F, 0, 15, () -> {
        return Ingredient.fromItems(Items.MELON_SLICE);
    }),
    COOKIE(66, 0.5F, -0.5F, 0, 20, () -> {
        return Ingredient.fromItems(Items.COOKIE);
    })
    ;

    int maxUses;
    float toolEfficiency;
    float attackDamage;
    int harvestLvl;
    int enchantability;
    LazyValue<Ingredient> repairMaterial;

    FoodSwordTiers(int uses, float efficiency, float damage, int harvest, int enchant, Supplier<Ingredient> material) {
        maxUses = uses;
        toolEfficiency = efficiency;
        attackDamage = damage;
        harvestLvl = harvest;
        enchantability = enchant;
        repairMaterial = new LazyValue(material);
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return toolEfficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLvl;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
}
