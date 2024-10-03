package com.udea.apptuneloriente.presentation.screens.login

sealed class AuthState{
    object Authenticated : AuthState()
    object UnAuthenticated : AuthState()
    object Loading : AuthState()
    data class Error(val message: String): AuthState()
}