package me.cg360.mod.grapple.mixin;

import me.cg360.mod.grapple.content.entity.grapplinghook.IExtendedSpawnPacketEntity;
import me.cg360.mod.grapple.network.NetworkManager;
import me.cg360.mod.grapple.network.clientbound.AddExtraDataMessage;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerEntity.class)
public class SendExtraEntityDataMixin {

    @Shadow @Final private Entity entity;

    @Inject(method = "addPairing(Lnet/minecraft/server/level/ServerPlayer;)V", at = @At("TAIL"))
    public void appendDataChain(ServerPlayer player, CallbackInfo ci) {
        if(this.entity instanceof IExtendedSpawnPacketEntity) {
            NetworkManager.packetToClient(new AddExtraDataMessage(this.entity), player);
        }
    }

}
