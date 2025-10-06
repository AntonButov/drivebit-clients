package my.drivebit.clients.di

object DiDefinitionRegistry {
    private val definitions = mutableSetOf<KClass<*>>()

    fun register(vararg types: KClass<*>) {
        definitions.addAll(types)
    }

    fun all(): Set<KClass<*>> = definitions
}

private typealias KClass<T> = kotlin.reflect.KClass<T>
