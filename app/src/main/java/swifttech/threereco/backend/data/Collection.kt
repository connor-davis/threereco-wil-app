package swifttech.threereco.backend.data

import java.util.UUID

data class Collection(
    val id: UUID,
    val businessId: UUID,
    val collectorId: UUID,
    val productId: UUID,
    val weight: String,
    val business: Business?,
    val collector: Collector?,
    val product: Product?
)
