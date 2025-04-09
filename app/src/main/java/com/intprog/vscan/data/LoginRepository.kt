package com.intprog.vscan.data

import com.intprog.vscan.data.model.LoggedInUser

class LoginRepository(private val dataSource: LoginDataSource) {
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        // Simulate a logged-in user
        // user = LoggedInUser("1", "John Doe")

        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    fun logout() {
        user = null
        // dataSource.logout()
    }

    fun login(username: String, password: String): Result<LoggedInUser> {
        // haddle login logic here
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
    }
}