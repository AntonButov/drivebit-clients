package my.drivebit.viewmodels

import my.drivebit.shared.storage.Storage

class IconUserViewModel(
    private val storage: Storage,
) {
    fun isUserLoggedIn(): Boolean = storage.isLogined()

    fun getUserToken(): String? = storage.getToken()

    fun saveUserToken(token: String) {
        storage.saveToken(token)
    }
}
