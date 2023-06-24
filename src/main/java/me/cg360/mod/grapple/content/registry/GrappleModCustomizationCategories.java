package me.cg360.mod.grapple.content.registry;

import me.cg360.mod.grapple.GrappleMod;
import me.cg360.mod.grapple.customization.CustomizationCategory;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.*;
import java.util.function.Supplier;

public class GrappleModCustomizationCategories {

    private static final HashMap<ResourceLocation, Entry<? extends CustomizationCategory>> categories;

    static {
        categories = new LinkedHashMap<>();
    }

    public static <P extends CustomizationCategory> Entry<P> category(String id, Supplier<P> type) {
        ResourceLocation qualId = GrappleMod.id(id);
        Entry<P> entry = new Entry<>(qualId, type);
        categories.put(qualId, entry);
        return entry;
    }


    public static void registerAll() {
        for(Map.Entry<ResourceLocation, Entry<?>> def: categories.entrySet()) {
            ResourceLocation id = def.getKey();
            Entry<?> data = def.getValue();
            CustomizationCategory it = data.getFactory().get();

            data.finalize(Registry.register(GrappleModMetaRegistry.CUSTOMIZATION_CATEGORIES, id, it));
        }
    }

    // rename to reinforcement?
    public static final Entry<CustomizationCategory> LIMITS = category("limits", () -> new CustomizationCategory(
            GrappleModItems.LIMITS_UPGRADE.get()
    ));

    public static final Entry<CustomizationCategory> ROPE = category("rope", () -> new CustomizationCategory(
            GrappleModItems.ROPE_UPGRADE.get(),
            GrappleModCustomizationProperties.MAX_ROPE_LENGTH.get(), GrappleModCustomizationProperties.BLOCK_PHASE_ROPE.get(), GrappleModCustomizationProperties.STICKY_ROPE.get()
    ));

    // TODO: Group gravity with playermovementmult in a physics tab maybe?
    public static final Entry<CustomizationCategory> HOOK_THROWER = category("hook_thrower", () -> new CustomizationCategory(
            GrappleModItems.THROW_UPGRADE.get(),
            GrappleModCustomizationProperties.HOOK_GRAVITY_MULTIPLIER.get(), GrappleModCustomizationProperties.HOOK_THROW_SPEED.get(), GrappleModCustomizationProperties.HOOK_THROW_ANGLE.get(), GrappleModCustomizationProperties.HOOK_THROW_ANGLE_ON_SNEAK.get(),
            GrappleModCustomizationProperties.HOOK_REEL_IN_ON_SNEAK.get(), GrappleModCustomizationProperties.DETACH_HOOK_ON_KEY_UP.get()
    ));

    public static final Entry<CustomizationCategory> MOTOR = category("motor", () -> new CustomizationCategory(
            GrappleModItems.MOTOR_UPGRADE.get(),
            GrappleModCustomizationProperties.MOTOR_ATTACHED.get(), GrappleModCustomizationProperties.MOTOR_ACCELERATION.get(), GrappleModCustomizationProperties.MAX_MOTOR_SPEED.get(), GrappleModCustomizationProperties.MOTOR_ACTIVATION.get(),
            GrappleModCustomizationProperties.SMART_MOTOR.get(), GrappleModCustomizationProperties.MOTOR_DAMPENER.get(), GrappleModCustomizationProperties.MOTOR_WORKS_BACKWARDS.get()
    ));

    public static final Entry<CustomizationCategory> SWING = category("swing", () -> new CustomizationCategory(
            GrappleModItems.SWING_UPGRADE.get(),
            GrappleModCustomizationProperties.MOVE_SPEED_MULTIPLIER.get()
    ));

    public static final Entry<CustomizationCategory> ENDER_STAFF = category("ender_staff", () -> new CustomizationCategory(
            GrappleModItems.ENDER_STAFF_UPGRADE.get(),
            GrappleModCustomizationProperties.ENDER_STAFF_ATTACHED.get()
    ));

    public static final Entry<CustomizationCategory> FORCEFIELD = category("forcefield", () -> new CustomizationCategory(
            GrappleModItems.FORCE_FIELD_UPGRADE.get(),
            GrappleModCustomizationProperties.FORCEFIELD_ATTACHED.get(), GrappleModCustomizationProperties.FORCEFIELD_FORCE.get()
    ));

    public static final Entry<CustomizationCategory> MAGNET = category("magnet", () -> new CustomizationCategory(
            GrappleModItems.MAGNET_UPGRADE.get(),
            GrappleModCustomizationProperties.MAGNET_ATTACHED.get(), GrappleModCustomizationProperties.MAGNET_RADIUS.get()
    ));

    public static final Entry<CustomizationCategory> DOUBLE_HOOK = category("double_hook", () -> new CustomizationCategory(
            GrappleModItems.DOUBLE_UPGRADE.get(),
            GrappleModCustomizationProperties.DOUBLE_HOOK_ATTACHED.get(), GrappleModCustomizationProperties.DOUBLE_SMART_MOTOR.get(), GrappleModCustomizationProperties.SINGLE_ROPE_PULL.get(),
            GrappleModCustomizationProperties.DOUBLE_HOOK_ANGLE.get(), GrappleModCustomizationProperties.DOUBLE_HOOK_ANGLE_ON_SNEAK.get()
    ));

    public static final Entry<CustomizationCategory> ROCKET = category("rocket", () -> new CustomizationCategory(
            GrappleModItems.ROCKET_UPGRADE.get(),
            GrappleModCustomizationProperties.ROCKET_ATTACHED.get(), GrappleModCustomizationProperties.ROCKET_FORCE.get(), GrappleModCustomizationProperties.ROCKET_ANGLE.get(),
            GrappleModCustomizationProperties.ROCKET_FUEL_DEPLETION_RATIO.get(), GrappleModCustomizationProperties.ROCKET_REFUEL_RATIO.get()
    ));

    public static Set<Entry<? extends CustomizationCategory>> getModCategories() {
        return Set.copyOf(categories.values());
    }


    public static class Entry<T extends CustomizationCategory> extends AbstractRegistryReference<T> {

        protected Entry(ResourceLocation id, Supplier<T> factory) {
            super(id, factory);
        }
    }


}
