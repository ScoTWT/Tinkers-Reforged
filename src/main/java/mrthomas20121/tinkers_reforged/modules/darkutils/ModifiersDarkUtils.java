package mrthomas20121.tinkers_reforged.modules.darkutils;

import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.ModuleManager;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.modifier.ModShulkerPearl;
import net.darkhax.darkutils.features.shulkerpearl.FeatureShulkerPearlItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModifiersDarkUtils implements ModuleBase {

    public static ModShulkerPearl shulkerPearl = new ModShulkerPearl();

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {

    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {

        if(TinkersReforgedConfig.SettingMaterials.modifiers.shulker_pearl) {
            shulkerPearl.addItem(FeatureShulkerPearlItem.itemShulkerPearl);
        }
        ModuleManager.addModifier(shulkerPearl);
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
