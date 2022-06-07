package dependencyInjection

import kotlin.reflect.KClass
import kotlin.reflect.cast
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.jvmErasure

class UserResource(private val service: UserService) {
    fun getAll() = service.getAll()
}

fun main() {
    containerExample(Container())
}

fun containerExample(container: IContainer) {
    // prints false
    println(container.hasInstance(UserService::class))
    val ur = container.getOrCreateInstance(UserResource::class)
    val us = container.getOrCreateInstance(UserService::class)
    us.add(User("2b2f", 1))

    // prints [User(id=1, username="2b2f")]
    println(ur.getAll())

    // still prints [User(id=1, username="2b2f")]
    println(container.createInstance(UserResource::class).getAll())

    // prints [], because new instance has no users
    println(container.createInstance(UserService::class).getAll())
}




class Container : IContainer {
    private val instances: MutableMap<KClass<*>, Any> = mutableMapOf()
    override fun <T : Any> createInstance(kClass: KClass<T>): T {
        val param = kClass.primaryConstructor!!.parameters
        val constructorParams = param.associateWith {getOrCreateInstance(it.type.jvmErasure)}
        val instance = kClass.primaryConstructor!!.callBy(constructorParams)
        instances[kClass] = instance
        return instance
    }

    override fun <T : Any> getOrCreateInstance(kClass: KClass<T>): T {
        return if (instances.containsKey(kClass)) kClass.cast(instances[kClass])
        else createInstance(kClass)
    }

    override fun hasInstance(kClass: KClass<*>): Boolean {
        return instances.containsKey(kClass)
    }
}