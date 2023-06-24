package me.cg360.mod.grapple.client.integration;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.cg360.mod.grapple.GrappleMod;
import me.cg360.mod.grapple.config.GrappleModLegacyConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.gui.screens.AlertScreen;
import net.minecraft.network.chat.Component;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return GrappleMod.isConfigSuccessfullyInitialized()
                ? screen -> AutoConfig.getConfigScreen(GrappleModLegacyConfig.class, screen).get()
                : screen -> new AlertScreen(
                screen::onClose,
                Component.translatable("grapplemod.config.failed_integration.title"),
                Component.translatable("grapplemod.config.failed_integration.description")
        );
    }

}
