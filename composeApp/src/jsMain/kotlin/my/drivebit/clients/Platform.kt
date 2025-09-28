package my.drivebit.clients

actual fun getPlatform(): Platform =
    object : Platform {
        override val name: String = "Web"
    }
