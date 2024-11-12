package swifttech.threereco.backend.data

import java.util.UUID

data class Product(
    val id: UUID,
    val businessId: UUID,
    val name: String,
    val price: String,
    val gwCode: String,
    val carbonFactor: String,
    val business: Business?
)
