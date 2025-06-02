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
    public static final RegistryObject<Item> GOLD_RAW = ITEMS.register("gold_raw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLD = ITEMS.register("gold",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_RAW = ITEMS.register("iridium_raw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM = ITEMS.register("iridium",
            () -> new Item(new Item.Properties()));

// TOOLS
    // Hoes
    public static final RegistryObject<Item> HOE = ITEMS.register("hoe",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLD_HOE = ITEMS.register("gold_hoe",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_HOE = ITEMS.register("iridium_hoe",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
