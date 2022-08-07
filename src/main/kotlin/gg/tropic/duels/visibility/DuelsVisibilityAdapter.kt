package gg.tropic.duels.visibility

import net.evilblock.cubed.visibility.VisibilityAction
import net.evilblock.cubed.visibility.VisibilityAdapter
import org.bukkit.entity.Player

/**
 * @author AgentRKID
 * @since 8/6/2022
 */
object DuelsVisibilityAdapter : VisibilityAdapter
{
    override fun getAction(toRefresh: Player, refreshFor: Player): VisibilityAction
    {
        return VisibilityAction.HIDE
    }
}