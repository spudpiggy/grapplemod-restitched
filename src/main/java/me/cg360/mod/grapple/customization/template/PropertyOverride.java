package me.cg360.mod.grapple.customization.template;

import me.cg360.mod.grapple.customization.type.CustomizationProperty;

public record PropertyOverride<T>(CustomizationProperty<T> property, T value) {

    public PropertyOverride {
        if(property == null) throw new IllegalArgumentException("Property cannot be null");
    }

}
