package gg.tropic.duels.kit

import gg.scala.common.Savable
import gg.scala.store.storage.storable.IDataStoreObject
import org.bukkit.inventory.ItemStack
import java.util.*

/**
 * @author AgentRKID
 * @since 8/7/2022
 */
class Kit(
    override val identifier: UUID = UUID.randomUUID()
) : IDataStoreObject
{

    lateinit var inventoryContents: Array<ItemStack>


}