package com.udea.apptuneloriente.data.model

data class Event(
    val id: String? = null,
    val type: String = "",
    val startDate: String = "",
    val estimatedTime: String = ""
) {
    // Constructor sin argumentos requerido por Firestore
    constructor() : this(null, "", "", "")
}
