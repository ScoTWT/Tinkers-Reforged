package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.tinkers_reforged.Reference;
import mrthomas20121.tinkers_reforged.library.ForgeUtils;
import mrthomas20121.tinkers_reforged.library.MaterialGen;
import mrthomas20121.tinkers_reforged.ReforgedTraits;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.ModuleBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class MaterialsRS extends ModuleBase {

    private final MaterialGen quartz_enriched_iron = new MaterialGen("quartz_enriched_iron", 0xF1F0EC, "QuartzEnrichedIron", 500);

    public MaterialsRS() {
        super(new ResourceLocation(Reference.refined_storage, "module"));
    }

    @Override
    public boolean canLoad() {
        return TinkersReforgedConfig.SettingMaterials.modules.refined_storage;
    }

    @Override
    public void preInit() {
        if(TinkersReforgedConfig.SettingMaterials.materials.quartz_enriched_iron) {
            quartz_enriched_iron.preInit();
            quartz_enriched_iron.getMaterial().addTrait(ReforgedTraits.enriching, MaterialTypes.HEAD);
            quartz_enriched_iron.getMaterial().addTrait(TinkerTraits.magnetic2);
            TinkerRegistry.addMaterial(quartz_enriched_iron.getMaterial());
            TinkerRegistry.addMaterialStats(quartz_enriched_iron.getMaterial(),
                    new HeadMaterialStats(204, 6.05f, 4.20f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1f, 60),
                    new ExtraMaterialStats(50),
                    new BowMaterialStats(0.9f, 3f, 7.9f));
        }
    }

    @Override
    public void init() {
        OreDictionary.registerOre("ingotQuartzEnrichedIron", ForgeUtils.getItem(Reference.refined_storage, "quartz_enriched_iron"));
        if(TinkersReforgedConfig.SettingMaterials.materials.quartz_enriched_iron) {
            quartz_enriched_iron.init();
            quartz_enriched_iron.getMaterial().setRepresentativeItem(ForgeUtils.getItem(Reference.refined_storage, "quartz_enriched_iron"));
            quartz_enriched_iron.getMaterial().setRepresentativeItem("ingotQuartzEnrichedIron");
        }
    }
}
