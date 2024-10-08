package com.udea.apptuneloriente.presentation.screens.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel() : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

    init {
        checkAuthStatus()
    }

    val emailSent = mutableStateOf(false)
    val errorMessage = mutableStateOf("")

    fun checkAuthStatus() {
        if (auth.currentUser == null) {
            _authState.value = AuthState.UnAuthenticated
        } else {
            _authState.value = AuthState.Authenticated
        }
    }

    fun login(email: String, password: String) {

        if(email.isEmpty() || password.isEmpty()) {
            _authState.value = AuthState.Error("Email or password can't be empty")
            return
        }
        _authState.value = AuthState.Loading
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task->
                if (task.isSuccessful) {
                    _authState.value = AuthState.Authenticated
                } else {
                    _authState.value = AuthState.Error(task.exception?.message ?: "Something went wrong")
                }
            }
    }

    /* Puede servir para la lógica de crear eventos
    fun signUp(email: String, password: String) {

        if(email.isEmpty() || password.isEmpty()) {
            _authState.value = AuthState.Error("Email or password can't be empty")
            return
        }
        _authState.value = AuthState.Loading
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task->
                if (task.isSuccessful) {
                    _authState.value = AuthState.Authenticated
                } else {
                    _authState.value = AuthState.Error(task.exception?.message ?: "Something went wrong")
                }
            }
    }
    */

    fun signOut() {
        auth.signOut()
        _authState.value = AuthState.UnAuthenticated
    }

    fun recoverPassword(email: String) {
        if (email.isNotEmpty()) {
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        emailSent.value = true
                    } else {
                        errorMessage.value = "Error: ${task.exception?.message}"
                    }
                }
        } else {
            errorMessage.value = "Por favor, ingresa un correo válido."
        }
    }
}
