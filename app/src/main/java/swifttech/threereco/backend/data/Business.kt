package swifttech.threereco.backend.data

import java.util.UUID

enum class BusinessType {
    Recycler,
    WasteCollector,
    BuyBackCenter,
}

data class Business(
    val id: UUID,
    val userId: UUID?,
    val name: String,
    val description: String,
    val phoneNumber: String,
    val address: String,
    val city: String,
    val province: String,
    val zipCode: String,
    val type: BusinessType,
    val user: User?
)