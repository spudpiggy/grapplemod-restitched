package me.cg360.mod.grapple.customization;

import me.cg360.mod.grapple.content.item.upgrade.BaseUpgradeItem;
import me.cg360.mod.grapple.content.registry.GrappleModMetaRegistry;
import me.cg360.mod.grapple.customization.type.CustomizationProperty;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CustomizationCategory {

    private final BaseUpgradeItem upgradeItem;
    private final List<CustomizationProperty<?>> linkedProperties;

    public CustomizationCategory(BaseUpgradeItem upgradeItem, CustomizationProperty<?>... unlocks) {
        this.upgradeItem = upgradeItem;
        this.linkedProperties = List.of(unlocks);
    }


    public String getLocalization(String suffix) {
        String path = this.getIdentifier().toString().replaceAll("[:/\\\\]", ".");
        boolean includeConnectingDot = suffix != null && suffix.length() > 0 && !suffix.startsWith(".");
        return "grapple_category%s%s".formatted(includeConnectingDot ? "." : "", path);
    }

    public ResourceLocation getIdentifier() {
        return GrappleModMetaRegistry.CUSTOMIZATION_CATEGORIES.getKey(this);
    }

    public BaseUpgradeItem getUpgradeItem() {
        return this.upgradeItem;
    }

    public Component getName() {
        return Component.translatable(this.getLocalization("name"));
    }

    public Component getDescription() {
        return Component.translatable(this.getLocalization("desc"));
    }

    public Set<CustomizationProperty<?>> getLinkedProperties() {
        return new LinkedHashSet<>(this.linkedProperties);
    }

    public boolean shouldRender() {
        return !this.linkedProperties.isEmpty();
    }
}
