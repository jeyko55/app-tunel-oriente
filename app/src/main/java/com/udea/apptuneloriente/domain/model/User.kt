package com.udea.apptuneloriente.domain.model

data class User(
    val id: String,
    val email: String?,
    val name: String? = null
)