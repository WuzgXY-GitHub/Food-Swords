package quek.food_swords;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(FoodSwordsMod.MODID)
public class FoodSwordsMod {

    public static final String MODID = "food_swords";

    public FoodSwordsMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        FoodSwordsItems.ITEMS.register(bus);
    }

}
