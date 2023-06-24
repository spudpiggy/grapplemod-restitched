package me.cg360.mod.grapple.customization.template;

import me.cg360.mod.grapple.content.registry.GrappleModItems;
import me.cg360.mod.grapple.customization.CustomizationAvailability;
import me.cg360.mod.grapple.customization.CustomizationVolume;
import me.cg360.mod.grapple.customization.type.CrouchToggle;
import me.cg360.mod.grapple.customization.type.CustomizationProperty;
import me.cg360.mod.grapple.content.registry.GrappleModCustomizationProperties;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.util.*;

// These mimic the old recipes, automatically checking if a given template is valid.
public class GrapplingHookTemplate {

    private static final Map<String, GrapplingHookTemplate> defaultTemplates = new LinkedHashMap<>();

    private static GrapplingHookTemplate register(GrapplingHookTemplate template) {
        GrapplingHookTemplate.defaultTemplates.put(template.getId().toLowerCase(), template);
        return template;
    }

    private static <T> PropertyOverride<T> property(GrappleModCustomizationProperties.Entry<? extends CustomizationProperty<T>> id, T value) {
        if(id == null) throw new IllegalArgumentException("Identifier property entry cannot be null.");
        return property(id.get(), value);
    }

    private static <T> PropertyOverride<T> property(CustomizationProperty<T> id, T value) {
        if(id == null) throw new IllegalArgumentException("Identifier property cannot be null.");
        return new PropertyOverride<>(id, value);
    }

    public static Collection<GrapplingHookTemplate> getTemplates() {
        return Collections.unmodifiableCollection(defaultTemplates.values());
    }


    public static final GrapplingHookTemplate ENDER_HOOK = register(new GrapplingHookTemplate(
            "ender_hook", Component.translatable("grapple_template.ender_hook.name"),
            property(GrappleModCustomizationProperties.HOOK_THROW_SPEED, 3.5d),
            property(GrappleModCustomizationProperties.MAX_ROPE_LENGTH, 60.0d),

            property(GrappleModCustomizationProperties.ENDER_STAFF_ATTACHED, true)
    ));

    public static final GrapplingHookTemplate MOTOR_HOOK = register(new GrapplingHookTemplate(
            "motor_hook", Component.translatable("grapple_template.motor_hook.name"),
            property(GrappleModCustomizationProperties.HOOK_THROW_SPEED, 3.5d),
            property(GrappleModCustomizationProperties.MAX_ROPE_LENGTH, 60.0d),

            property(GrappleModCustomizationProperties.MOTOR_ATTACHED, true),
            property(GrappleModCustomizationProperties.MOVE_SPEED_MULTIPLIER, 2.0d)
    ));

    public static final GrapplingHookTemplate SMART_HOOK = register(new GrapplingHookTemplate(
            "smart_hook", Component.translatable("grapple_template.smart_hook.name"),
            property(GrappleModCustomizationProperties.HOOK_THROW_SPEED, 3.5d),
            property(GrappleModCustomizationProperties.MAX_ROPE_LENGTH, 60.0d),

            property(GrappleModCustomizationProperties.MOTOR_ATTACHED, true),
            property(GrappleModCustomizationProperties.SMART_MOTOR, true),
            property(GrappleModCustomizationProperties.MOVE_SPEED_MULTIPLIER, 2.0d)
    ));

    public static final GrapplingHookTemplate MAGNET_HOOK = register(new GrapplingHookTemplate(
            "magnet_hook", Component.translatable("grapple_template.magnet_hook.name"),
            property(GrappleModCustomizationProperties.HOOK_THROW_SPEED, 3.5d),
            property(GrappleModCustomizationProperties.MAX_ROPE_LENGTH, 60.0d),

            property(GrappleModCustomizationProperties.MAGNET_ATTACHED, true),
            property(GrappleModCustomizationProperties.FORCEFIELD_ATTACHED, true)
    ));

    public static final GrapplingHookTemplate ROCKET_HOOK = register(new GrapplingHookTemplate(
            "rocket_hook", Component.translatable("grapple_template.rocket_hook.name"),
            property(GrappleModCustomizationProperties.HOOK_THROW_SPEED, 3.5d),
            property(GrappleModCustomizationProperties.MAX_ROPE_LENGTH, 60.0d),

            property(GrappleModCustomizationProperties.ROCKET_ATTACHED, true)
    ));

    public static final GrapplingHookTemplate DOUBLE_MOTOR_HOOK = register(new GrapplingHookTemplate(
            "double_motor_hook", Component.translatable("grapple_template.double_motor_hook.name"),
            property(GrappleModCustomizationProperties.HOOK_THROW_SPEED, 20.0d),
            property(GrappleModCustomizationProperties.MAX_ROPE_LENGTH, 60.0d),

            property(GrappleModCustomizationProperties.DOUBLE_HOOK_ATTACHED, true),
            property(GrappleModCustomizationProperties.MOTOR_ATTACHED, true),
            property(GrappleModCustomizationProperties.MAX_MOTOR_SPEED, 10.0d),
            property(GrappleModCustomizationProperties.STICKY_ROPE, true),

            property(GrappleModCustomizationProperties.HOOK_GRAVITY_MULTIPLIER, 50.0d),
            property(GrappleModCustomizationProperties.DOUBLE_HOOK_ANGLE, 30.0d),
            property(GrappleModCustomizationProperties.DOUBLE_HOOK_ANGLE_ON_SNEAK, 25.0d),
            property(GrappleModCustomizationProperties.HOOK_REEL_IN_ON_SNEAK, false),

            property(GrappleModCustomizationProperties.MOTOR_ACTIVATION, CrouchToggle.WHEN_NOT_CROUCHING),
            property(GrappleModCustomizationProperties.DOUBLE_SMART_MOTOR, true),

            property(GrappleModCustomizationProperties.HOOK_THROW_ANGLE, 25.0d),
            property(GrappleModCustomizationProperties.HOOK_THROW_ANGLE_ON_SNEAK, 0.0d),

            property(GrappleModCustomizationProperties.MOVE_SPEED_MULTIPLIER, 2.0d)
    ));

    public static final GrapplingHookTemplate DOUBLE_ROCKET_MOTOR_HOOK = register(new GrapplingHookTemplate(
            "double_rocket_motor_hook", Component.translatable("grapple_template.double_rocket_motor_hook.name"),
            property(GrappleModCustomizationProperties.HOOK_THROW_SPEED, 20.0d),
            property(GrappleModCustomizationProperties.MAX_ROPE_LENGTH, 60.0d),

            property(GrappleModCustomizationProperties.DOUBLE_HOOK_ATTACHED, true),
            property(GrappleModCustomizationProperties.MOTOR_ATTACHED, true),
            property(GrappleModCustomizationProperties.MAX_MOTOR_SPEED, 10.0d),
            property(GrappleModCustomizationProperties.STICKY_ROPE, true),

            property(GrappleModCustomizationProperties.HOOK_GRAVITY_MULTIPLIER, 50.0d),
            property(GrappleModCustomizationProperties.DOUBLE_HOOK_ANGLE, 30.0d),
            property(GrappleModCustomizationProperties.DOUBLE_HOOK_ANGLE_ON_SNEAK, 25.0d),
            property(GrappleModCustomizationProperties.HOOK_REEL_IN_ON_SNEAK, false),

            property(GrappleModCustomizationProperties.MOTOR_ACTIVATION, CrouchToggle.WHEN_NOT_CROUCHING),
            property(GrappleModCustomizationProperties.DOUBLE_SMART_MOTOR, true),

            property(GrappleModCustomizationProperties.HOOK_THROW_ANGLE, 25.0d),
            property(GrappleModCustomizationProperties.HOOK_THROW_ANGLE_ON_SNEAK, 0.0d),

            property(GrappleModCustomizationProperties.ROCKET_ATTACHED, true),
            property(GrappleModCustomizationProperties.ROCKET_ANGLE, 30.0d),

            property(GrappleModCustomizationProperties.MOVE_SPEED_MULTIPLIER, 2.0d)
    ));


    private final String identifier;
    private final Component displayName;
    private final Set<PropertyOverride<?>> properties;

    private GrapplingHookTemplate(String identifier, PropertyOverride<?>... properties) {
        this(identifier, null, properties);
    }

    private GrapplingHookTemplate(String identifier, Component displayName, PropertyOverride<?>... properties) {
        this.identifier = identifier;
        this.displayName = displayName;
        this.properties = Set.of(properties);
    }

    public String getId() {
        return this.identifier;
    }

    public Component getDisplayName() {
        return this.displayName;
    }

    public boolean isEnabled() {
        return properties.stream()
                .map(PropertyOverride::property)
                .noneMatch(p -> p.getAvailability() == CustomizationAvailability.BLOCKED); // 2 = Disabled Fully.
    }

    public CustomizationVolume getCustomizations() {
        CustomizationVolume customization = new CustomizationVolume();
        properties.forEach(customization::set);
        return customization;
    }

    public ItemStack getAsStack() {
        ItemStack itemStack = GrappleModItems.GRAPPLING_HOOK.get().getDefaultInstance();
        if(this.getDisplayName() != null)
            itemStack.setHoverName(this.getDisplayName().copy().withStyle(ChatFormatting.RESET));
        GrappleModItems.GRAPPLING_HOOK.get().setCustomOnServer(itemStack, this.getCustomizations());

        return itemStack;
    }
}
