package gg.tropic.duels.spawn.menu

import gg.tropic.duels.TropicDuelsPlugin
import gg.tropic.duels.spawn.SpawnConfig
import gg.tropic.duels.spawn.menu.editor.EditWelcomeMessageMenu
import gg.tropic.duels.system.menu.SystemManagementMenu
import net.evilblock.cubed.menu.Button
import net.evilblock.cubed.menu.Menu
import net.evilblock.cubed.util.CC
import net.evilblock.cubed.util.bukkit.ItemBuilder
import net.evilblock.cubed.util.bukkit.Tasks
import org.bukkit.Material
import org.bukkit.entity.Player

/**
 * @author AgentRKID
 * @since 8/8/2022
 */
class SpawnManagementMenu : Menu() {
    override fun getButtons(player: Player): Map<Int, Button> {
        return mutableMapOf(
            13 to ItemBuilder(Material.SIGN)
                .name("${CC.B_YELLOW}Edit Welcome Message")
                .toButton { _, _ ->
                    EditWelcomeMessageMenu(
                        TropicDuelsPlugin.instance.config<SpawnConfig>().welcomeMessage
                    ).openMenu(player)
                }
        )
    }

    override fun onClose(player: Player, manualClose: Boolean) {
        if (manualClose)
        {
            Tasks.delayed(1L) {
                SystemManagementMenu().openMenu(player)
            }
        }
    }

    override fun size(buttons: Map<Int, Button>): Int {
        return 9 * 3
    }
}