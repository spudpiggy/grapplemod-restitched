package me.cg360.mod.grapple.content.enchantment;

import me.cg360.mod.grapple.config.GrappleModLegacyConfig;
import me.cg360.mod.grapple.config.ConfigUtility;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class SlidingEnchantment extends Enchantment {
	public SlidingEnchantment() {
		super(ConfigUtility.getRarityFromInt(GrappleModLegacyConfig.getConf().enchantments.slide.enchant_rarity_sliding), EnchantmentCategory.ARMOR_FEET, new EquipmentSlot[] {EquipmentSlot.FEET});
	}
	
	@Override
    public int getMinCost(int enchantmentLevel)
    {
        return 1;
    }

	@Override
    public int getMaxCost(int enchantmentLevel)
    {
        return this.getMinCost(enchantmentLevel) + 40;
    }

	@Override
	public int getMaxLevel()
    {
        return 1;
    }
}
