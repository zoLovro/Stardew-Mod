package net.roburo.stardewmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.roburo.stardewmod.StardewMod;
import net.roburo.stardewmod.item.custom.IridiumHoeItem;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StardewMod.MOD_ID);

    // Materials
    public static final RegistryObject<Item> IRIDIUM = ITEMS.register("iridium",
            () -> new Item(new Item.Properties()));


    // Hoes
    public static final RegistryObject<Item> IRIDIUMHOE = ITEMS.register("iridium_hoe",
            () -> new Item(new Item.Properties().durability(33)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
