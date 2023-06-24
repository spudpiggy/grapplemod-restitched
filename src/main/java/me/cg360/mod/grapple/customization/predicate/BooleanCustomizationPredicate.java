package me.cg360.mod.grapple.customization.predicate;

import me.cg360.mod.grapple.customization.type.CustomizationProperty;

public class BooleanCustomizationPredicate extends SingleCustomizationPredicate<Boolean> {

    private final Boolean expectedValue;

    public BooleanCustomizationPredicate(CustomizationProperty<Boolean> property, Boolean expectedValue) {
        super(property);
        this.expectedValue = expectedValue;
    }

    @Override
    public boolean shouldPass(Boolean value) {
        if(expectedValue == null || value == null)
            return expectedValue == value;

        return expectedValue.booleanValue() == value.booleanValue();
    }

    public Boolean getExpectedValue() {
        return this.expectedValue;
    }
}
