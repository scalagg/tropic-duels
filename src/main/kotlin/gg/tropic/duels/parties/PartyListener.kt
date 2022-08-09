package gg.tropic.duels.parties

import gg.scala.commons.annotations.Listeners
import gg.scala.parties.event.PartyDisbandEvent
import gg.scala.parties.event.PartyJoinEvent
import gg.scala.parties.event.PartyLeaveEvent
import net.evilblock.cubed.visibility.VisibilityHandler
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler

/**
 * @author AgentRKID
 * @since 8/8/2022
 */
@Listeners
class PartyListener
{
    @EventHandler
    fun onPartyJoin(event: PartyJoinEvent)
    {
        val player = Bukkit.getPlayer(event.member.uniqueId)

        if (player != null)
        {
            VisibilityHandler.update(player)
        }
    }

    @EventHandler
    fun onPartyDisband(event: PartyDisbandEvent)
    {
        for (member in event.party.members)
        {
            val player = Bukkit.getPlayer(member.key)

            if (player != null)
            {
                VisibilityHandler.update(player)
            }
        }
    }

    @EventHandler
    fun onPartyLeave(event: PartyLeaveEvent)
    {
        val player = Bukkit.getPlayer(event.member.uniqueId)

        if (player != null)
        {
            VisibilityHandler.update(player)
        }
    }
}