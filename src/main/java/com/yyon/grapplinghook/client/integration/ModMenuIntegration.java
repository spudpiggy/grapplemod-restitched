package com.yyon.grapplinghook.client.integration;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import com.yyon.grapplinghook.GrappleMod;
import com.yyon.grapplinghook.config.GrappleModLegacyConfig;
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
