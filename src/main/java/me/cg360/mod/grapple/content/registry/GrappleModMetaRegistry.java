package me.cg360.mod.grapple.content.registry;

import me.cg360.mod.grapple.GrappleMod;
import me.cg360.mod.grapple.customization.CustomizationCategory;
import me.cg360.mod.grapple.customization.type.CustomizationProperty;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public class GrappleModMetaRegistry {

    public static final ResourceKey<Registry<CustomizationProperty<?>>> CUSTOMIZATION_PROPERTIES_KEY = ResourceKey.createRegistryKey(GrappleMod.id("customization_property"));
    public static final ResourceKey<Registry<CustomizationCategory>> CUSTOMIZATION_CATEGORY_KEY = ResourceKey.createRegistryKey(GrappleMod.id("customization_category"));


    public static final MappedRegistry<CustomizationProperty<?>> CUSTOMIZATION_PROPERTIES = FabricRegistryBuilder
            .createSimple(CUSTOMIZATION_PROPERTIES_KEY)
            .attribute(RegistryAttribute.SYNCED)
            .buildAndRegister();

    public static final MappedRegistry<CustomizationCategory> CUSTOMIZATION_CATEGORIES = FabricRegistryBuilder
            .createSimple(CUSTOMIZATION_CATEGORY_KEY)
            .buildAndRegister();

}
