package net.roburo.stardewmod.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.roburo.stardewmod.StardewMod;
import net.roburo.stardewmod.item.custom.*;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StardewMod.MOD_ID);

// MATERIALS
    //
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
            () -> new HoeItem(Tiers.STONE, new Item.Properties().durability(100)));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe",
            CopperHoeItem::new);
    public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe",
            SteelHoeItem::new);
    public static final RegistryObject<Item> GOLD_HOE = ITEMS.register("gold_hoe",
            GoldHoeItem::new);
    public static final RegistryObject<Item> IRIDIUM_HOE = ITEMS.register("iridium_hoe",
            IridiumHoeItem::new);

    // Axes
    public static final RegistryObject<Item> AXE = ITEMS.register("axe",
            () -> new AxeItem(Tiers.STONE, new Item.Properties().durability(100)));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe",
            () -> new AxeItem(Tiers.STONE, new Item.Properties().durability(150)));
    public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe",
            () -> new AxeItem(Tiers.IRON, new Item.Properties().durability(200)));
    public static final RegistryObject<Item> GOLD_AXE = ITEMS.register("gold_axe",
            () -> new AxeItem(Tiers.GOLD, new Item.Properties().durability(250)));
    public static final RegistryObject<Item> IRIDIUM_AXE = ITEMS.register("iridium_axe",
            () -> new AxeItem(Tiers.DIAMOND, new Item.Properties().durability(300)));

    // Scythes
    public static final RegistryObject<Item> SCYTHE = ITEMS.register("scythe",
            () -> new ScytheItem(new Item.Properties(), Tiers.STONE));
    public static final RegistryObject<Item> GOLD_SCYTHE = ITEMS.register("gold_scythe",
            () -> new ScytheItem(new Item.Properties(), Tiers.GOLD));
    public static final RegistryObject<Item> IRIDIUM_SCYTHE = ITEMS.register("iridium_scythe",
            () -> new ScytheItem(new Item.Properties(), Tiers.DIAMOND));

    // Pickaxes
    public static final RegistryObject<Item> PICKAXE = ITEMS.register("pickaxe",
            () -> new PickaxeItem(Tiers.STONE, new Item.Properties().durability(100)));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(Tiers.STONE, new Item.Properties().durability(150)));
    public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(Tiers.IRON, new Item.Properties().durability(200)));
    public static final RegistryObject<Item> GOLD_PICKAXE = ITEMS.register("gold_pickaxe",
            () -> new PickaxeItem(Tiers.GOLD, new Item.Properties().durability(250)));
    public static final RegistryObject<Item> IRIDIUM_PICKAXE = ITEMS.register("iridium_pickaxe",
            () -> new PickaxeItem(Tiers.DIAMOND, new Item.Properties().durability(300)));

    // Watering cans

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
