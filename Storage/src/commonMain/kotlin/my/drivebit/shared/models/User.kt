package my.drivebit.shared.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val name: String,
    val email: String,
    val phone: String? = null,
    val avatar: String? = null,
)

@Serializable
data class UserProfile(
    val user: User,
    val preferences: UserPreferences,
)

@Serializable
data class UserPreferences(
    val theme: String = "light",
    val language: String = "en",
    val notifications: Boolean = true,
)
