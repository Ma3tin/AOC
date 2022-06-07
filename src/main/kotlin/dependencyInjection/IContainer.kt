package dependencyInjection

import kotlin.reflect.KClass

interface IContainer {
    fun <T : Any> createInstance(kClass: KClass<T>): T
    fun <T : Any> getOrCreateInstance(kClass: KClass<T>): T
    fun hasInstance(kClass: KClass<*>): Boolean
}