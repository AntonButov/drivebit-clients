package my.drivebit.viewmodels

import my.drivebit.shared.storage.Storage

class IconUserViewModel(
    private val storage: Storage,
) {
    val userIconUrl: String
        get() =
            if (storage.isLogined()) {
                "$imageUrl/menu/user.svg"
            } else {
                "$imageUrl/menu/user.svg"
            }
}
