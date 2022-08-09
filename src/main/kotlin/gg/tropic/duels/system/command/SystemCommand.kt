package gg.tropic.duels.system.command

import gg.scala.commons.acf.CommandHelp
import gg.scala.commons.acf.annotation.CommandAlias
import gg.scala.commons.acf.annotation.CommandPermission
import gg.scala.commons.acf.annotation.Default
import gg.scala.commons.acf.annotation.HelpCommand
import gg.scala.commons.acf.annotation.Subcommand
import gg.scala.commons.acf.annotation.Syntax
import gg.scala.commons.annotations.commands.AutoRegister
import gg.scala.commons.command.ScalaCommand
import gg.tropic.duels.system.menu.SystemManagementMenu
import org.bukkit.entity.Player

/**
 * @author AgentRKID
 * @since 8/8/2022
 */
@AutoRegister
@CommandAlias("system")
@CommandPermission("duels.command.system")
object SystemCommand : ScalaCommand()
{
    @Default
    @HelpCommand
    @Syntax("[page]")
    fun onHelp(help: CommandHelp)
    {
        help.showHelp()
    }

    @Subcommand("manage")
    fun onManage(player: Player)
    {
        SystemManagementMenu().openMenu(player)
    }
}