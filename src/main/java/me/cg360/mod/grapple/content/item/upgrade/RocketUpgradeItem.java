package me.cg360.mod.grapple.content.item.upgrade;

import me.cg360.mod.grapple.content.registry.GrappleModCustomizationCategories;

public class RocketUpgradeItem extends BaseUpgradeItem {
	public RocketUpgradeItem() {
		super(1, GrappleModCustomizationCategories.ROCKET::get);
	}
}
