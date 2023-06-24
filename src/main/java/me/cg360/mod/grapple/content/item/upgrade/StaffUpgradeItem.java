package me.cg360.mod.grapple.content.item.upgrade;

import me.cg360.mod.grapple.content.registry.GrappleModCustomizationCategories;

public class StaffUpgradeItem extends BaseUpgradeItem {
	public StaffUpgradeItem() {
		super(1, GrappleModCustomizationCategories.ENDER_STAFF::get);
	}
}
