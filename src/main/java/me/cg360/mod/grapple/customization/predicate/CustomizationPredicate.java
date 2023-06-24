package me.cg360.mod.grapple.customization.predicate;

import me.cg360.mod.grapple.customization.CustomizationVolume;

public interface CustomizationPredicate<T> {

    boolean shouldPass(CustomizationVolume volume);
    boolean shouldPass(T value);

}
