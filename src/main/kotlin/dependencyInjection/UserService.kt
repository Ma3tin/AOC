package dependencyInjection

class UserService {
    private val users: MutableList<User> = mutableListOf()

    fun add(user: User) {
        users.add(user)
    }

    fun getAll(): List<User> {
        return users
    }
}
