package com.udea.apptuneloriente.presentation.screens.management

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udea.apptuneloriente.data.model.Event
import com.udea.apptuneloriente.data.repository.eventrepository.EventRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ManagementViewModel(
    private val eventRepository: EventRepository
) : ViewModel() {

    private val _events = MutableStateFlow<List<Event>>(emptyList())
    val events: StateFlow<List<Event>> = _events.asStateFlow()
    init {
        viewModelScope.launch {
            eventRepository.getEvents().collect { events ->
                _events.value = events
            }
        }
    }

    private val _errorState = MutableStateFlow<String?>(null)
    val errorState: StateFlow<String?> = _errorState.asStateFlow()

    fun createEvent(event: Event) {
        viewModelScope.launch {
            try {
                eventRepository.createEvent(event)
                // Evento creado exitosamente
            } catch (e: Exception) {
                _errorState.value = e.message
            }
        }
    }

    fun updateEvent(event: Event) {
        viewModelScope.launch {
            try {
                eventRepository.updateEvent(event)
            } catch (e: Exception) {
                _errorState.value = e.message
            }
        }
    }

    fun deleteEvent(eventId: String) {
        viewModelScope.launch {
            try {
                eventRepository.deleteEvent(eventId)
            } catch (e: Exception) {
                _errorState.value = e.message
            }
        }
    }
}