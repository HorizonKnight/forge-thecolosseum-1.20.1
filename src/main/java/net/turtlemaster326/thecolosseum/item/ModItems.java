package net.turtlemaster326.thecolosseum.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.turtlemaster326.thecolosseum.TheColosseum;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TheColosseum.MOD_ID);

    public static final RegistryObject<Item> BLACKOPAL = ITEMS.register("black_opal",
            () -> new Item(new Item.Properties()));








    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
