package gg.tropic.duels.spawn

import gg.scala.flavor.inject.Inject
import gg.scala.flavor.service.Configure
import gg.scala.flavor.service.Service
import gg.scala.lemon.hotbar.HotbarPreset
import gg.scala.lemon.hotbar.HotbarPresetHandler
import gg.tropic.duels.TropicDuelsPlugin
import io.papermc.lib.PaperLib
import me.lucko.helper.Events
import org.bukkit.event.player.PlayerJoinEvent

/**
 * @author AgentRKID
 * @since 8/6/2022
 */
@Service
object SpawnService
{

    @Inject
    private lateinit var plugin: TropicDuelsPlugin

    lateinit var hotbar: HotbarPreset

    @Configure
    fun configure()
    {
        val config = plugin.config<SpawnConfig>()

        // TODO: Build hotbar setup
        hotbar = HotbarPreset()

        HotbarPresetHandler.startTrackingHotbar("spawn", hotbar)

        Events.subscribe(PlayerJoinEvent::class.java)
            .handler { event ->
                config.welcomeMessage.forEach { event.player.sendMessage(it) }
                event.player.teleport(config.spawnLocation)
            }
            .bindWith(plugin)
    }

}