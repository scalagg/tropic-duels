package gg.tropic.duels.visibility

import gg.scala.parties.service.PartyService
import net.evilblock.cubed.visibility.VisibilityAction
import net.evilblock.cubed.visibility.VisibilityAdapter
import net.evilblock.cubed.visibility.VisibilityAdapterRegister
import org.bukkit.entity.Player

/**
 * @author AgentRKID
 * @since 8/6/2022
 */

@VisibilityAdapterRegister("duels-visibility")
class DuelsVisibilityAdapter : VisibilityAdapter
{
    override fun getAction(toRefresh: Player, refreshFor: Player): VisibilityAction
    {
        val party = PartyService.findPartyByUniqueId(toRefresh)

        if (party != null) {
            if (party.includedMembers().contains(refreshFor.uniqueId)) {
                return VisibilityAction.NEUTRAL
            }
        }
        return VisibilityAction.HIDE
    }
}