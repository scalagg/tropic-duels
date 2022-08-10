package gg.tropic.duels.kit

import gg.scala.common.Savable
import gg.scala.store.storage.storable.IDataStoreObject
import gg.scala.store.storage.type.DataStoreStorageType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import java.util.*
import java.util.concurrent.CompletableFuture

/**
 * @author AgentRKID
 * @since 8/7/2022
 */
class Kit(
    override val identifier: UUID = UUID.randomUUID(),
    val name: String
) : IDataStoreObject, Savable
{

    var menuPriority = 1
    var hidden = false

    var icon = ItemStack(Material.GRASS)

    lateinit var armorContents: Array<ItemStack>
    lateinit var inventoryContents: Array<ItemStack>
    lateinit var editorContents: Array<ItemStack>
    override fun save(): CompletableFuture<Void>
    {
        return KitService.controller.save(this, DataStoreStorageType.MONGO)
    }

    fun delete(): CompletableFuture<Void>
    {
        return KitService.controller.delete(identifier, DataStoreStorageType.MONGO).thenRun {
            KitService.kits.remove(identifier)
        }
    }


}