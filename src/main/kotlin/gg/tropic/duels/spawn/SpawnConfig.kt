package gg.tropic.duels.spawn

import net.evilblock.cubed.util.CC
import org.bukkit.Location
import xyz.mkotb.configapi.comment.Comment

/**
 * @author AgentRKID
 * @since 8/6/2022
 */
class SpawnConfig
{

    @Comment("The set spawn location")
    lateinit var spawnLocation: Location

    @Comment("The welcome message to appear to players on login")
    var welcomeMessage: ArrayList<String> = arrayListOf(
        "",
        "${CC.B_PRI} WELCOME TO NA PRACTICE!",
        "${CC.I_GRAY} Click a sword to start fighting...",
        ""
    )

}