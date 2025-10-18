package my.drivebit.viewmodels

import my.drivebit.shared.storage.Storage

class IconUserViewModel(
    private val storage: Storage,
) {
    val userIconUrl: String
        get() =
            if (storage.isLogined()) {
                "$imageUrl/user.svg"
            } else {
                "$imageUrl/user.svg"
            }
}
