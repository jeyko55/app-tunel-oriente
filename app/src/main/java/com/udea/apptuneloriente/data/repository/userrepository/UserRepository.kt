package com.udea.apptuneloriente.data.repository.userrepository

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class UserRepository {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    suspend fun checkAuthStatus(): Boolean {
        return auth.currentUser != null
    }

    suspend fun login(email: String, password: String): Boolean {
        if (email.isEmpty() || password.isEmpty()) {
            return false // O lanzar una excepción si lo prefieres
        }
        return try {
            auth.signInWithEmailAndPassword(email, password).await()
            true // Login successful
        } catch (e: Exception) {
            false // Login failed
        }
    }

    suspend fun signOut() {
        auth.signOut()
    }

    suspend fun recoverPassword(email: String): String? {
        if (email.isEmpty()) {
            return "Por favor, ingresa un correo válido."
        }

        try {
            val signInMethods = auth.fetchSignInMethodsForEmail(email).await().signInMethods
            if (signInMethods == null || signInMethods.isEmpty()) {
                return "El correo no está registrado."
            }

            auth.sendPasswordResetEmail(email).await()
            return null // No error
        } catch (e: Exception) {
            return "Error: ${e.message}"
        }
    }

    // Nuevo método para obtener el email del usuario autenticado
    fun getCurrentUserEmail(): String? {
        val user = auth.currentUser
        return user?.email
    }
}