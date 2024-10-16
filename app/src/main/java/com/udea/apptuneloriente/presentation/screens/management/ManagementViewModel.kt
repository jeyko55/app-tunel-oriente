package com.udea.apptuneloriente.presentation.screens.management

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.udea.apptuneloriente.domain.model.Event
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ManagementViewModel : ViewModel() {
    private val firestore = Firebase.firestore
    private val eventsCollection = firestore.collection("events")

    fun createEvent(event: Event) {
        viewModelScope.launch {
            try {
                eventsCollection.add(event).await()
                // Evento creado exitosamente
            } catch (e: Exception) {
                // Maneja el error
            }
        }
    }

    fun getEvents(): Flow<List<Event>> = callbackFlow {
        val listener = eventsCollection.addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                close(exception)
                return@addSnapshotListener
            }

            val events = snapshot?.toObjects(Event::class.java) ?: emptyList()
            trySend(events)
        }
        awaitClose { listener.remove() }
    }

    fun updateEvent(event: Event) {
        viewModelScope.launch {
            try {
                eventsCollection.document(event.id!!).set(event).await()
                // Evento actualizado exitosamente
            } catch (e: Exception) {
                // Maneja el error
            }
        }
    }

    fun deleteEvent(eventId: String) {
        viewModelScope.launch {
            try {
                eventsCollection.document(eventId).delete().await()
                // Evento eliminado exitosamente
            } catch (e: Exception) {
                // Maneja el error
            }
        }
    }
}