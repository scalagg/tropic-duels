package gg.tropic.duels.spawn.editor

import gg.tropic.duels.TropicDuelsPlugin
import gg.tropic.duels.spawn.SpawnConfig
import net.evilblock.cubed.menu.menus.TextEditorMenu
import org.bukkit.entity.Player

/**
 * @author AgentRKID
 * @since 8/8/2022
 */
class EditWelcomeMessageMenu(welcomeMessage: MutableList<String>) : TextEditorMenu(lines = welcomeMessage)
{
    override fun getPrePaginatedTitle(player: Player): String
    {
        return "Edit Welcome Message"
    }

    override fun onSave(player: Player, list: List<String>)
    {
        TropicDuelsPlugin.instance.config<SpawnConfig>().welcomeMessage = list.toMutableList()
    }

    override fun onClose(player: Player)
    {
        TODO("Create Spawn configuration menu for other spawn stuff")
    }

}