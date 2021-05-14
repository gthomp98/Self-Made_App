package com.example.self_madeapp.data

//this is the auth user class, the class that is returned on login, as initially a token was needed to access the api
data class AuthUser (
    val name: String,
    val email: String,
    val token: String

)