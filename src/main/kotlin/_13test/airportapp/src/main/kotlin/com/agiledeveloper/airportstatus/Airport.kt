package com.agiledeveloper.airportstatus

import com.beust.klaxon.*

data class Airport(
    @Json(name = "IATA") val code: String,
    @Json(name = "Name") val name: String,
    @Json(name = "Delay") val delay: Boolean
) {
    companion object {
        fun sort(airports: List<Airport>): List<Airport> {
            return airports.sortedBy { it.name }
        }

        fun getAirportData(code: String): Airport {
            println("getAirportData called")
            return try {
                // fetchData 返回为 {} 时会报异常
                // om.beust.klaxon.KlaxonException: Unable to instantiate Airport with parameters []
                Klaxon().parse<Airport>(fetchData(code)) as Airport
            } catch (e: Exception) {
                Airport("ERR", "Invalid airport", false)
            }
        }

        fun fetchData(code: String): String =
            java.net.URL("https://soa.smext.faa.gov/asws/api/airport/status/$code")
                .readText()
    }
}