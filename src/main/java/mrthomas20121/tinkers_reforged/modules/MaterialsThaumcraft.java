package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.tinkers_reforged.Reference;
import mrthomas20121.tinkers_reforged.library.MaterialGen;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.ModuleBase;
import mrthomas20121.tinkers_reforged.trait.TraitFluxForce;
import mrthomas20121.tinkers_reforged.trait.TraitThaumicBomb;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;

public class MaterialsThaumcraft extends ModuleBase {

    private final MaterialGen thaumium = new MaterialGen("thaumium", 0x7768A9, "Thaumium", 800);

    private final TraitFluxForce fluxForce = new TraitFluxForce();
    private final TraitThaumicBomb thaumicBomb = new TraitThaumicBomb();

    public MaterialsThaumcraft() {
        super(new ResourceLocation(Reference.thaumcraft, "module"));
    }

    @Override
    public boolean canLoad() {
        return TinkersReforgedConfig.SettingMaterials.modules.thaumcraft;
    }

    @Override
    public void preInit() {
        if(TinkersReforgedConfig.SettingMaterials.materials.thaumium) {
            thaumium.preInit();
            thaumium.getMaterial().addTrait(fluxForce, MaterialTypes.HEAD);
            thaumium.getMaterial().addTrait(thaumicBomb, MaterialTypes.HANDLE);
            thaumium.getMaterial().addTrait(thaumicBomb, MaterialTypes.EXTRA);
            TinkerRegistry.addMaterial(thaumium.getMaterial());
            TinkerRegistry.addMaterialStats(thaumium.getMaterial(),
                    new HeadMaterialStats(100, 4.5f, 4.4f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.1f, 30),
                    new ExtraMaterialStats(5),
                    new BowMaterialStats(2.3f, 5.5f, 3.3f));
        }
    }

    @Override
    public void init() {
        if(TinkersReforgedConfig.SettingMaterials.materials.thaumium) {
            thaumium.init();
        }
    }
}
