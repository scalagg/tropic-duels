package gg.tropic.duels.kit.command

import gg.scala.commons.acf.CommandHelp
import gg.scala.commons.acf.ConditionFailedException
import gg.scala.commons.acf.annotation.CommandAlias
import gg.scala.commons.acf.annotation.CommandPermission
import gg.scala.commons.acf.annotation.Default
import gg.scala.commons.acf.annotation.HelpCommand
import gg.scala.commons.acf.annotation.Optional
import gg.scala.commons.acf.annotation.Private
import gg.scala.commons.acf.annotation.Subcommand
import gg.scala.commons.acf.annotation.Syntax
import gg.scala.commons.annotations.commands.AutoRegister
import gg.scala.commons.command.ScalaCommand
import gg.tropic.duels.kit.Kit
import gg.tropic.duels.kit.KitService
import gg.tropic.duels.kit.result.KitPaginatedResult
import net.evilblock.cubed.util.CC
import org.bukkit.command.CommandSender
import java.util.*

/**
 * @author AgentRKID
 * @since 8/9/2022
 */
@AutoRegister
@CommandAlias("kit")
class KitCommand : ScalaCommand()
{

    @Default
    @HelpCommand
    @Syntax("[page]")
    fun onHelp(help: CommandHelp)
    {
        help.showHelp()
    }

    @Subcommand("create")
    @CommandPermission("duels.command.kit.create")
    @Private
    fun onCreate(
        sender: CommandSender,
        kitName: String
    )
    {
        if (KitService.findKitByName(kitName) != null)
        {
            throw ConditionFailedException("There is already a kit by the name of ${CC.YELLOW}$kitName ${CC.RED}made.")
        }

        val kit = Kit(UUID.randomUUID(), kitName)
        KitService.kits[kit.identifier] = kit

        kit.save().thenRun {
            sender.sendMessage("${CC.GREEN}You've successfully created a new kit named ${CC.YELLOW}$kitName${CC.GREEN}.")
        }
    }

    @Subcommand("delete")
    @CommandPermission("duels.command.kit.delete")
    @Private
    fun onDelete(
        sender: CommandSender,
        kit: Kit
    )
    {
        kit.delete().thenRun {
            sender.sendMessage("${CC.GREEN}You've successfully deleted a kit named ${CC.YELLOW}${kit.name}${CC.GREEN}.")
        }
    }

    @Subcommand("list")
    @Syntax("[page]")
    fun onList(sender: CommandSender, @Optional page: Int?)
    {
        KitPaginatedResult().display(sender, KitService.kits.values, page ?: 1)
    }
}