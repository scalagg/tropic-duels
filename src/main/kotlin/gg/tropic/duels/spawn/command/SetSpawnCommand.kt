package gg.tropic.duels.spawn.command

import gg.scala.commons.acf.annotation.CommandAlias
import gg.scala.commons.acf.annotation.CommandPermission
import gg.scala.commons.annotations.commands.AutoRegister
import gg.scala.commons.command.ScalaCommand
import gg.tropic.duels.TropicDuelsPlugin
import gg.tropic.duels.spawn.SpawnConfig
import net.evilblock.cubed.util.CC
import org.bukkit.entity.Player

/**
 * @author AgentRKID
 * @since 8/8/2022
 */
@AutoRegister
object SetSpawnCommand : ScalaCommand()
{

    @CommandAlias("setspawn")
    @CommandPermission("duels.command.setspawn")
    fun onSetSpawn(player: Player)
    {
        val config = TropicDuelsPlugin.instance.config<SpawnConfig>()
        config.spawnLocation = player.location.clone()
        player.sendMessage("${CC.GREEN}You've set the spawn location to your current location")
    }

}