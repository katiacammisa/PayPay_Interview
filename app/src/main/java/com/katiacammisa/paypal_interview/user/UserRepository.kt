package com.katiacammisa.paypal_interview.user

import javax.inject.Inject

class UserRepository @Inject constructor() {

    fun validateCredentials(username: String, password: String): Boolean {
        // Should be suspend if querying to db
        return username == credentials.username && password == credentials.password
    }

    companion object {
        val credentials = UserCredentials("katia", "katia1234")
    }
}

data class UserCredentials(
    val username: String,
    val password: String
)