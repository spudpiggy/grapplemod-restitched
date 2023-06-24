package me.cg360.mod.grapple.content.item.upgrade;

import me.cg360.mod.grapple.content.registry.GrappleModCustomizationCategories;

public class MotorUpgradeItem extends BaseUpgradeItem {
	public MotorUpgradeItem() {
		super(1, GrappleModCustomizationCategories.MOTOR::get);
	}
}
