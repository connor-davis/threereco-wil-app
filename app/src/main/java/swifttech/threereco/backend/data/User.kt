package swifttech.threereco.backend.data

import java.util.UUID

enum class Roles {
    Admin,
    Business,
    Collector,
    Guest,
}

data class User(
    val id: UUID,
    val email: String,
    val roles: List<Roles>
)

data class UserAuthentication(
    val email: String,
    val password: String,
)

data class UserAuthenticationResponse(
    val user: User,
    val accessToken: String,
)
