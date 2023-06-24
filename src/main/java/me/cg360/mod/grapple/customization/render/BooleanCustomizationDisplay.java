package me.cg360.mod.grapple.customization.render;

import me.cg360.grapplemod.client.gui.widget.CustomizationCheckbox;
import me.cg360.mod.grapple.customization.CustomizationVolume;
import me.cg360.mod.grapple.customization.type.BooleanProperty;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.function.Supplier;

public class BooleanCustomizationDisplay extends AbstractCustomizationDisplay<Boolean, BooleanProperty> {

    public BooleanCustomizationDisplay(BooleanProperty property) {
        super(property);
    }

    @Override
    public Component getModificationHint(Boolean value) {
        if(value == null) return null;
        String checkboxString = value
                ? "[x]"
                : "[ ]";
        return this.getProperty().getDisplayName().copy().append(": " + checkboxString);
    }

    @Override
    public AbstractWidget getConfigurationUIElement(Supplier<CustomizationVolume> source, Screen context, Runnable onUpdate, int x, int y, int advisedWidth, int advisedHeight) {
        return new CustomizationCheckbox(source, x, y, advisedWidth, advisedHeight, this.getProperty(), onUpdate);
    }

}
