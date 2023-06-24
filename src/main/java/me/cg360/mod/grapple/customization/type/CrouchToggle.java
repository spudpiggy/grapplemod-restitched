package me.cg360.mod.grapple.customization.type;

import com.yyon.grapplinghook.client.GrappleModClient;
import me.cg360.grapplemod.client.keybind.GrappleModKey;
import me.cg360.grapplemod.client.keybind.MinecraftKey;
import me.cg360.mod.grapple.util.FriendlyNameProvider;

public enum CrouchToggle implements FriendlyNameProvider {

    ALWAYS, WHEN_CROUCHING, WHEN_NOT_CROUCHING;

    public boolean isActive(GrappleModKey keybind) {
        return this.isActive(GrappleModClient.get().isKeyDown(keybind));
    }

    public boolean isActive(MinecraftKey keybind) {
        return this.isActive(GrappleModClient.get().isKeyDown(keybind));
    }

    public boolean isActive(boolean isKeyDown) {
        if(this == ALWAYS) return true;
        return (this == WHEN_CROUCHING) == isKeyDown;
    }

    @Override
    public String getFriendlyName() {
        return "crouch_activation";
    }
}
