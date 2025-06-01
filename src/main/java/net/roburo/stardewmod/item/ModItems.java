package net.roburo.stardewmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.roburo.stardewmod.StardewMod;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StardewMod.MOD_ID);

    // Creating item instances
    /*public static final RegistryObject<Item> ADVANCEDBONEMEAL = ITEMS.register("advancedbonemeal",
            () -> new AdvancedBoneMealItem(new Item.Properties()));*/

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
