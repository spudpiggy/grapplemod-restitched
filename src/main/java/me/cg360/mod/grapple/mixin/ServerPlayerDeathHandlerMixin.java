package me.cg360.mod.grapple.mixin;

import me.cg360.mod.grapple.util.SharedDamageHandler;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public class ServerPlayerDeathHandlerMixin {

    @Inject(method = "die(Lnet/minecraft/world/damagesource/DamageSource;)V", at = @At("HEAD"), cancellable = true)
    public void handleDeath(DamageSource source, CallbackInfo ci){
        if(SharedDamageHandler.handleDeath((Entity) (Object) this)) ci.cancel();
    }



}
