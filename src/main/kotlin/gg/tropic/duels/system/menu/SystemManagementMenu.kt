package gg.tropic.duels.system.menu

import gg.tropic.duels.spawn.menu.SpawnManagementMenu
import net.evilblock.cubed.menu.Button
import net.evilblock.cubed.menu.Menu
import net.evilblock.cubed.util.CC
import net.evilblock.cubed.util.bukkit.ItemBuilder
import org.bukkit.Material
import org.bukkit.entity.Player

/**
 * @author AgentRKID
 * @since 8/8/2022
 */
class SystemManagementMenu : Menu()
{
    override fun getTitle(player: Player): String {
        return "System Management"
    }

    override fun getButtons(player: Player): Map<Int, Button> {
        return mutableMapOf(
            13 to ItemBuilder(Material.MOB_SPAWNER)
                .name("${CC.B_YELLOW}Manage Spawn")
                .toButton { _, _ ->
                    SpawnManagementMenu().openMenu(player)
                }
        )
    }

    override fun size(buttons: Map<Int, Button>): Int {
        return 9 * 3
    }
}