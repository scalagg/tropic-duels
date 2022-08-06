package gg.tropic.duels

import gg.scala.commons.ExtendedScalaPlugin
import gg.scala.commons.annotations.container.ContainerEnable
import me.lucko.helper.plugin.ap.Plugin
import me.lucko.helper.plugin.ap.PluginDependency

/**
 * @author GrowlyX
 * @since 8/6/2022
 */
@Plugin(
    name = "duels",
    depends = [
        PluginDependency("Lemon"),
        PluginDependency("scala-commons"),
        PluginDependency("store-spigot")
    ]
)
class TropicDuelsPlugin : ExtendedScalaPlugin()
{
    @ContainerEnable
    fun containerEnable()
    {
        // asdf
    }
}
