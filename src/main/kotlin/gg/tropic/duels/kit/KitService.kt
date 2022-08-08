package gg.tropic.duels.kit

import gg.scala.flavor.service.Close
import gg.scala.flavor.service.Configure
import gg.scala.flavor.service.Service
import gg.scala.store.controller.DataStoreObjectController
import gg.scala.store.controller.DataStoreObjectControllerCache
import gg.scala.store.storage.type.DataStoreStorageType
import java.util.UUID

/**
 * @author AgentRKID
 * @since 8/7/2022
 */
@Service
object KitService
{

    lateinit var controller: DataStoreObjectController<Kit>
    lateinit var kits: Map<UUID, Kit>

    @Configure
    fun configure()
    {
        controller = DataStoreObjectControllerCache.create()
        kits = controller.loadAll(DataStoreStorageType.MONGO).get();
    }

}