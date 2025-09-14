package my.drivebit.clients

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform