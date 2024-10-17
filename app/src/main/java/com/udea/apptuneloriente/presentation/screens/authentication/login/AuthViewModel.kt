package com.udea.apptuneloriente.presentation.screens.authentication.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udea.apptuneloriente.data.repository.userrepository.UserRepository
import kotlinx.coroutines.launch

class AuthViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

    val userNameFromEmail = mutableStateOf<String?>(null)

    init {
        // Obtenemos el email y extraemos el nombre de usuario
        val email = userRepository.getCurrentUserEmail()
        userNameFromEmail.value = email?.substringBefore('@')
    }

    init {
        viewModelScope.launch {
            _authState.value = if (userRepository.checkAuthStatus()) {
                AuthState.Authenticated
            } else {
                AuthState.UnAuthenticated
            }
        }
    }

    val emailSent = mutableStateOf(false)
    val errorMessage = mutableStateOf("")

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            val loginSuccessful = userRepository.login(email, password)
            _authState.value = if (loginSuccessful) {
                AuthState.Authenticated
            } else {
                AuthState.Error("Error de inicio de sesión") // Puedes personalizar el mensaje de error
            }
        }
    }

    fun signOut() {
        viewModelScope.launch {
            userRepository.signOut()
            _authState.value = AuthState.UnAuthenticated
        }
    }

    fun recoverPassword(email: String) {
        viewModelScope.launch {
            val error = userRepository.recoverPassword(email)
            if (error == null) {
                emailSent.value = true
            } else {
                errorMessage.value = error
            }
        }
    }
}
