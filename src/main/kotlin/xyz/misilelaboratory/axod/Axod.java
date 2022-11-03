package xyz.misilelaboratory.axod;

import java.text.DecimalFormat;

import mcp.mobius.waila.api.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

@SuppressWarnings("unused")
public class Axod implements ModInitializer, IWailaPlugin, IEntityComponentProvider {

    public static final Logger LOGGER = ModLog.getLogger();

    public static final String MOD_ID = "horseinfo";
    public static final String MOD_NAME = "Hwyla Addon Horse Info";
    private static final DecimalFormat FORMAT = new DecimalFormat("#.##");
    
    @Override
    public void onInitialize() {

    }
    
    @Override
    public void register(IRegistrar registrar) {

        registrar.addComponent(this, TooltipPosition.BODY, Player.class);
        registrar.addOverride(this, Player.class);
    }

    @Override
    public Entity getOverride(IEntityAccessor accessor, IPluginConfig config) {
        if (accessor.getEntity() instanceof Player e) {
            return IEntityComponentProvider.EMPTY_ENTITY;
        }
        return null;
    }

    @Override
    public void appendBody(ITooltip tooltip, IEntityAccessor accessor, IPluginConfig config) {
        final Entity entity = accessor.getEntity();

        if (entity instanceof final Player p) {
            final Inventory i = p.getInventory();
            final ItemStack a1 = i.getItem(9);
            final ItemStack a2 = i.getItem(10);
            final ItemStack a3 = i.getItem(11);
            final ItemStack a4 = i.getItem(12);

            tooltip.addLine();
            tooltip.addLine(Component.literal("i9" + a1.getDisplayName() + ":" + a1.getDescriptionId()));
            tooltip.addLine(Component.literal("i10" + a2.getDisplayName() + ":" + a2.getDescriptionId()));
            tooltip.addLine(Component.literal("i11" + a3.getDisplayName() + ":" + a3.getDescriptionId()));
            tooltip.addLine(Component.literal("i12" + a4.getDisplayName() + ":" + a4.getDescriptionId()));
        }
    }
}