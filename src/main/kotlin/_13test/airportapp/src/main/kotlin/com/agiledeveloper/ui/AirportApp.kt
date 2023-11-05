package com.agiledeveloper.ui

import kotlinx.coroutines.*
import com.agiledeveloper.airportstatus.getAirportStatus

fun main() = runBlocking {
    getAirportStatus(listOf("SFO", "IAD", "IAH", "ORD", "LAX"))
        .forEach { println(it) }
}