package gg.tropic.duels.kit.result

import gg.tropic.duels.kit.Kit
import net.evilblock.cubed.util.CC
import net.evilblock.cubed.util.bukkit.PaginatedResult

/**
 * @author AgentRKID
 * @since 8/9/2022
 */
class KitPaginatedResult : PaginatedResult<Kit>(10)
{
    override fun format(result: Kit, resultIndex: Int): String
    {
        return "${CC.PRI}#${resultIndex + 1} ${CC.WHITE}- ${CC.GRAY}${result.name} ${CC.WHITE}- ${if (result.hidden) "${CC.RED}Hidden" else "${CC.GREEN}Shown"}"
    }

    override fun getHeader(page: Int, maxPages: Int): String
    {
        return "${CC.PRI}=== ${CC.SEC}Kits ${CC.GRAY}($page/$maxPages) ${CC.PRI}==="
    }
}