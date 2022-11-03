package xyz.misilelaboratory.axod

import mcp.mobius.waila.api.*
import net.fabricmc.api.ModInitializer
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.player.Player

@SuppressWarnings("unused")
class Axod: ModInitializer, IWailaPlugin, IEntityComponentProvider {

    override fun onInitialize() {

    }

    override fun register(registrar: IRegistrar) {
        registrar.addComponent(this, TooltipPosition.BODY, Player::class.java)
        registrar.addOverride(this, Player::class.java)
    }

    override fun getOverride(accessor: IEntityAccessor, config: IPluginConfig): Entity? {
        if (accessor.getEntity<Player>() is Player) {
            return IEntityComponentProvider.EMPTY_ENTITY
        }
        return null
    }

    override fun appendBody(tooltip: ITooltip, accessor: IEntityAccessor, config: IPluginConfig) {
        val entity = accessor.getEntity<Player>()

        if (entity is Player) {
            val i = entity.inventory
            val a1 = i.getItem(9)
            val a2 = i.getItem(10)
            val a3 = i.getItem(11)
            val a4 = i.getItem(12)

            tooltip.addLine()
            tooltip.addLine(Component.literal("i9" + a1.displayName + ":" + a1.descriptionId))
            tooltip.addLine(Component.literal("i10" + a2.displayName + ":" + a2.descriptionId))
            tooltip.addLine(Component.literal("i11" + a3.displayName + ":" + a3.descriptionId))
            tooltip.addLine(Component.literal("i12" + a4.displayName + ":" + a4.descriptionId))
        }
    }
}