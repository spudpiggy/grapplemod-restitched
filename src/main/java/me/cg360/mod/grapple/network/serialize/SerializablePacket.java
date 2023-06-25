package me.cg360.mod.grapple.network.serialize;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

public abstract class SerializablePacket {

    public SerializablePacket() {

    }

    public SerializablePacket(FriendlyByteBuf buf) {
        this.decode(buf);
    }

    public abstract void decode(FriendlyByteBuf buf);

    public abstract void encode(FriendlyByteBuf buf);

    public abstract ResourceLocation getChannel();

}
