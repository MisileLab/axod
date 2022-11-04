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
        return null
    }

    override fun appendBody(tooltip: ITooltip, accessor: IEntityAccessor, config: IPluginConfig) {

        val entity: Player? = accessor.player

        if (entity is Player) {
            val i = entity.inventory
            print(i)

            tooltip.addLine()

            for (a in 9..12) {
                val b = i.getItem(a)
                tooltip.addLine(Component.literal("i$a - ${b.hoverName}:${b.item.description.contents}"))
            }
        }
    }
}
