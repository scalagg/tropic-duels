package gg.tropic.duels.spawn

import gg.scala.flavor.inject.Inject
import gg.scala.flavor.service.Configure
import gg.scala.flavor.service.Service
import gg.tropic.duels.TropicDuelsPlugin
import me.lucko.helper.Events
import org.bukkit.event.player.PlayerJoinEvent

/**
 * @author AgentRKID
 * @since 8/6/2022
 */
@Service
class SpawnService
{

    @Inject
    lateinit var plugin: TropicDuelsPlugin

    @Configure
    fun configure()
    {
        val config = plugin.config<SpawnConfig>()

        Events.subscribe(PlayerJoinEvent::class.java)
            .handler {
                it.player.sendMessage("Welcome to Tropic Practice")
                it.player.teleport(config.spawnLocation)
            }
            .bindWith(plugin)
    }

}