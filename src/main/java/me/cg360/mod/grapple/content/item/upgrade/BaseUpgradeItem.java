package me.cg360.mod.grapple.content.item.upgrade;

import me.cg360.mod.grapple.customization.CustomizationCategory;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class BaseUpgradeItem extends Item {

	private final Supplier<CustomizationCategory> category;

	public BaseUpgradeItem() {
		this(64, null);
	}

	public BaseUpgradeItem(int maxStackSize, Supplier<CustomizationCategory> theCategory) {
		super(new Item.Properties().stacksTo(maxStackSize));
		this.category = theCategory;
	}

	public CustomizationCategory getCategory() {
		return this.category.get();
	}
}
