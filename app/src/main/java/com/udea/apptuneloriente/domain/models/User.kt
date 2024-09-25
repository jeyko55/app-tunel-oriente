package com.udea.apptuneloriente.domain.models

data class User(
    val email: String,
    val password: String,
    val userRole: String
)