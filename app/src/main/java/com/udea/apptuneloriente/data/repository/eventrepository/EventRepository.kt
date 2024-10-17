package com.udea.apptuneloriente.data.repository.eventrepository

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.udea.apptuneloriente.data.model.Event
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class EventRepository {
    private val firestore = Firebase.firestore
    private val eventsCollection = firestore.collection("events")

    // Implementa las funciones de acceso a datos (CRUD) aquí
    suspend fun createEvent(event: Event) {
        eventsCollection.add(event).await()
    }

    suspend fun getEvents(): Flow<List<Event>> = callbackFlow {
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

    suspend fun updateEvent(event: Event) {
        eventsCollection.document(event.id!!).set(event).await()
    }

    suspend fun deleteEvent(eventId: String) {
        eventsCollection.document(eventId).delete().await()
    }
    // ... otras funciones de acceso a datos
}