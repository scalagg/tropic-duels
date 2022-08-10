package gg.tropic.duels

import gg.scala.commons.ExtendedScalaPlugin
import gg.scala.commons.annotations.container.ContainerDisable
import gg.scala.commons.annotations.container.ContainerEnable
import gg.scala.commons.config.annotations.ContainerConfig
import gg.scala.commons.proxy.Plugins
import gg.tropic.duels.spawn.SpawnConfig
import gg.tropic.duels.visibility.DuelsVisibilityAdapter
import me.lucko.helper.plugin.ap.Plugin
import me.lucko.helper.plugin.ap.PluginDependency
import net.evilblock.cubed.visibility.VisibilityHandler

/**
 * @author GrowlyX
 * @since 8/6/2022
 */
@Plugin(
    name = "duels",
    depends = [
        PluginDependency("Lemon"),
        PluginDependency("scala-commons"),
        PluginDependency("store-spigot"),
        PluginDependency("cloudsync", soft = true),
    ]
)
@ContainerConfig(
    "spawn",
    SpawnConfig::class
)
class TropicDuelsPlugin : ExtendedScalaPlugin()
{
    companion object
    {
        @JvmStatic
        val instance by Plugins.plugin<TropicDuelsPlugin>()
    }

    @ContainerEnable
    fun containerEnable()
    {

    }

    @ContainerDisable
    fun containerDisable()
    {

    }

}
