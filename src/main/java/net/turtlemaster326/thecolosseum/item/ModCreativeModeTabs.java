package net.turtlemaster326.thecolosseum.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.turtlemaster326.thecolosseum.TheColosseum;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheColosseum.MOD_ID);


    public static final RegistryObject<CreativeModeTab> COLOSSEUM_TAB = CREATIVE_MODE_TABS.register("colosseum_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.PURE_OPAL.get()))
                    .title(Component.translatable("creativetab.colosseum_tab"))
                    .displayItems((itemDisplayParameters, pOutput) -> {
                        pOutput.accept(ModItems.BLACK_OPAL.get());
                        pOutput.accept(ModItems.PURE_OPAL.get());



                    })
                    .build());


    public static  void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
