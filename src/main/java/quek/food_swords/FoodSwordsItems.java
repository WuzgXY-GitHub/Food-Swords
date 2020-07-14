package quek.food_swords;

import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FoodSwordsItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FoodSwordsMod.MODID);

    public static final RegistryObject<Item> MELON_SWORD = ITEMS.register("melon_sword", () ->
            new FoodSwordItem(FoodSwordTiers.MELON, (new Item.Properties()).group(FoodSwordsItems.FOOD_SWORDS).food(Foods.MELON_SLICE)));
    public static final RegistryObject<Item> COOKIE_SWORD = ITEMS.register("cookie_sword", () ->
            new FoodSwordItem(FoodSwordTiers.COOKIE, (new Item.Properties()).group(FoodSwordsItems.FOOD_SWORDS).food(Foods.COOKIE)));

    public static final ItemGroup FOOD_SWORDS = new ItemGroup("food_swords") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(COOKIE_SWORD.get());
        }
    };
}
