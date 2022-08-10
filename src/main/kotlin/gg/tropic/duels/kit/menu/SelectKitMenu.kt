package gg.tropic.duels.kit.menu

import gg.scala.peach.menu.ChatTagsMenu
import gg.tropic.duels.kit.Kit
import gg.tropic.duels.kit.KitService
import net.evilblock.cubed.menu.Button
import net.evilblock.cubed.menu.Menu
import net.evilblock.cubed.menu.pagination.PaginatedMenu
import net.evilblock.cubed.util.CC
import net.evilblock.cubed.util.bukkit.ItemBuilder
import net.evilblock.cubed.util.bukkit.Tasks
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.InventoryView
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

/**
 * @author AgentRKID
 * @since 8/9/2022
 */
class SelectKitMenu(
    private val title: String
) : PaginatedMenu()
{

    private lateinit var clickAction: (Player, Kit) -> Unit
    private var filter: (Player, Kit) -> Boolean = { _, _ -> true }

    init
    {
        placeholdBorders = true
    }

    private var closeMenu: Menu? = null

    fun closed(menu: Menu): SelectKitMenu
    {
        closeMenu = menu
        return this
    }

    fun filter(filter: (Player, Kit) -> Boolean): SelectKitMenu
    {
        this.filter = filter
        return this
    }

    fun clicked(
        lambda: (Player, Kit) -> Unit
    ): SelectKitMenu
    {
        clickAction = lambda
        return this
    }

    override fun getPrePaginatedTitle(player: Player): String = title

    override fun getAllPagesButtons(player: Player): Map<Int, Button>
    {
     return mutableMapOf<Int, Button>().also { buttons ->
         for (kit in KitService.kits.values.sortedBy { kit -> kit.menuPriority }) {
             if (kit.hidden && !player.hasPermission("duels.command.hide")) {
                 continue
             }
             buttons[buttons.size] = KitButton(kit)
         }
     }
    }

    override fun getAllPagesButtonSlots(): List<Int> = ChatTagsMenu.SLOTS

    override fun size(buttons: Map<Int, Button>): Int = 36

    override fun onClose(player: Player, manualClose: Boolean)
    {
        if (closeMenu != null && manualClose)
        {
            Tasks.sync { closeMenu!!.openMenu(player) }
        }
    }

    private inner class KitButton(
        private val kit: Kit
    ) : Button()
    {
        override fun getButtonItem(player: Player): ItemStack
        {
            return ItemBuilder(kit.icon)
                .name("${CC.B_YELLOW}${kit.name}")
                .addToLore("${CC.GRAY}Click to select!")
                .addFlags(
                    ItemFlag.HIDE_UNBREAKABLE,
                    ItemFlag.HIDE_ATTRIBUTES,
                    ItemFlag.HIDE_POTION_EFFECTS,
                    ItemFlag.HIDE_ENCHANTS
                )
                .build()
        }

        override fun clicked(
            player: Player, slot: Int,
            clickType: ClickType, view: InventoryView
        )
        {
            clickAction.invoke(player, kit)
        }
    }
}