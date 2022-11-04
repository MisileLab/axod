package xyz.misilelaboratory.axod

import mcp.mobius.waila.api.*
import net.fabricmc.api.ModInitializer
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.player.Player

@Suppress("unused")
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

            tooltip.addLine()

            for (a in 9..12) {
                val b = i.getItem(a)
                tooltip.addLine(Component.literal("i$a${b.displayName}:${b.descriptionId}"))
            }
        }
    }
}