package me.cg360.mod.grapple.content.item.upgrade;

import me.cg360.mod.grapple.content.registry.GrappleModCustomizationCategories;

public class ThrowUpgradeItem extends BaseUpgradeItem {
	public ThrowUpgradeItem() {
		super(1, GrappleModCustomizationCategories.HOOK_THROWER::get);
	}
}
