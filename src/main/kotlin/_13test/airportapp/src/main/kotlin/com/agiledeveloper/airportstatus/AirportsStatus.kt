package com.agiledeveloper.airportstatus

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

suspend fun getAirportStatus(codes: List<String>): List<Airport> {
    return withContext(Dispatchers.IO) {
        Airport.sort(codes.map { code -> async { Airport.getAirportData(code) }.await() })
    }
}