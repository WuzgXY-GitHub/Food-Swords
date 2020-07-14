package quek.food_swords;

import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FoodSwordsItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FoodSwordsMod.MODID);

    public static final RegistryObject<Item> MELON_SWORD = ITEMS.register("melon_sword", () ->
            new FoodSwordItem(FoodSwordTiers.MELON, (new Item.Properties()).group(ItemGroup.COMBAT).food(Foods.MELON_SLICE)));
}
