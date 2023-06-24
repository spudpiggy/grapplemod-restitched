package me.cg360.mod.grapple.content.registry;

import me.cg360.mod.grapple.GrappleMod;
import me.cg360.mod.grapple.content.enchantment.DoubleJumpEnchantment;
import me.cg360.mod.grapple.content.enchantment.SlidingEnchantment;
import me.cg360.mod.grapple.content.enchantment.WallrunEnchantment;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GrappleModEnchantments {

    private static final HashMap<ResourceLocation, EnchantmentEntry<?>> enchantments;

    static {
        enchantments = new HashMap<>();
    }

    public static <E extends Enchantment> EnchantmentEntry<E> enchantment(String id, Supplier<E> ench) {
        ResourceLocation qualId = GrappleMod.id(id);
        EnchantmentEntry<E> entry = new EnchantmentEntry<>(qualId, ench);
        enchantments.put(qualId, entry);
        return entry;
    }


    public static void registerAllEnchantments() {
        for(Map.Entry<ResourceLocation, EnchantmentEntry<?>> def: enchantments.entrySet()) {
            ResourceLocation id = def.getKey();
            EnchantmentEntry<?> data = def.getValue();
            Enchantment it = data.getFactory().get();

            data.finalize(Registry.register(BuiltInRegistries.ENCHANTMENT, id, it));
        }
    }

    public static final EnchantmentEntry<WallrunEnchantment> WALL_RUN = GrappleModEnchantments.enchantment("wallrunenchantment", WallrunEnchantment::new);
    public static final EnchantmentEntry<DoubleJumpEnchantment> DOUBLE_JUMP = GrappleModEnchantments.enchantment("doublejumpenchantment", DoubleJumpEnchantment::new);
    public static final EnchantmentEntry<SlidingEnchantment> SLIDING = GrappleModEnchantments.enchantment("slidingenchantment", SlidingEnchantment::new);

    public static class EnchantmentEntry<E extends Enchantment> extends AbstractRegistryReference<E> {
        protected EnchantmentEntry(ResourceLocation id, Supplier<E> factory) {
            super(id, factory);
        }
    }
}
