package me.cg360.mod.grapple.network.handle;

import me.cg360.mod.grapple.network.LogicalSide;
import me.cg360.mod.grapple.network.serialize.SerializablePacket;

public class CommonPacketHandler<P extends SerializablePacket> {

    public final void handle(SerializablePacket packet, LogicalSide sourceSide) {
        //generate context
    }

}
