package gg.tropic.duels.command

import gg.scala.commons.acf.ConditionFailedException
import gg.scala.commons.annotations.commands.customizer.CommandManagerCustomizer
import gg.scala.commons.command.ScalaCommandManager
import gg.tropic.duels.kit.Kit
import gg.tropic.duels.kit.KitService
import net.evilblock.cubed.util.CC

/**
 * @author AgentRKID
 * @since 8/9/2022
 */
object DuelsCommandCustomizer
{

    @CommandManagerCustomizer
    fun customize(
        manager: ScalaCommandManager
    )
    {
        manager.commandContexts.registerContext(Kit::class.java) { c ->
            val firstArg = c.popFirstArg()
            KitService.findKitByName(firstArg)
                ?: throw ConditionFailedException("No kit named ${CC.YELLOW}$firstArg ${CC.RED}was found")
        }
    }

}