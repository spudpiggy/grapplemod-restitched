package me.cg360.mod.grapple.util;

import me.cg360.mod.grapple.content.entity.grapplinghook.GrapplinghookEntity;
import me.cg360.mod.grapple.content.item.GrapplehookItem;
import me.cg360.mod.grapple.content.item.LongFallBootsItem;
import me.cg360.mod.grapple.network.clientbound.GrappleDetachMessage;
import me.cg360.mod.grapple.physics.PhysicsContextTracker;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.HashSet;

public class SharedDamageHandler {

    /** @return true if the death should be cancelled. */
    public static boolean handleDeath(Entity deadEntity) {
        if (deadEntity.level().isClientSide) return false;

        int id = deadEntity.getId();
        boolean isConnected = PhysicsContextTracker.allGrapplehookEntities.containsKey(id);

        if (isConnected) return false;

        HashSet<GrapplinghookEntity> grapplehookEntities = PhysicsContextTracker.allGrapplehookEntities.get(id);

        if(grapplehookEntities != null) {
            for (GrapplinghookEntity hookEntity : grapplehookEntities)
                hookEntity.removeServer();

            grapplehookEntities.clear();
        }

        PhysicsContextTracker.attached.remove(id);

        GrapplehookItem.grapplehookEntitiesLeft.remove(deadEntity);
        GrapplehookItem.grapplehookEntitiesRight.remove(deadEntity);

        if(deadEntity instanceof Player)
            GrappleModUtils.sendToCorrectClient(new GrappleDetachMessage(id), id, deadEntity.level());

        return false;
    }

    /** @return true if the death should be cancelled. */
    public static boolean handleDamage(Entity damagedEntity, DamageSource source) {
        if (!(damagedEntity instanceof Player player)) return false;

        for (ItemStack armor : player.getArmorSlots()) {
            if (armor != null && armor.getItem() instanceof LongFallBootsItem) continue;
            if (source.is(DamageTypes.FLY_INTO_WALL)) return true;
        }

        return false;
    }
}
