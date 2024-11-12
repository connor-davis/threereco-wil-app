package swifttech.threereco.backend.data

import java.util.UUID

data class Collector(
    val id: UUID,
    val userId: UUID?,
    val firstName: String,
    val lastName: String,
    val idNumber: String,
    val phoneNumber: String,
    val address: String,
    val city: String,
    val province: String,
    val zipCode: String,
    val bankName: String,
    val bankAccountHolder: String,
    val bankAccountNumber: String,
    val user: User?
)
