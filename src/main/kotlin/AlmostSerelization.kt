import kotlinx.serialization.json.*

fun serelization(o: Any?): JsonElement {
    when (o) {
        null -> return JsonNull
        is Number -> return JsonPrimitive(o)
        is String -> return JsonPrimitive(o)
        is Boolean -> return JsonPrimitive(o)
        is Array<*> -> return JsonArray(List(o.size) { index -> serelization(index) })
        else -> return JsonObject( o::class.members.associate { kCallable -> kCallable.name to serelization(kCallable.call(o)) })
    }
}