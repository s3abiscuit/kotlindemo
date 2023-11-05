package com.agiledeveloper.airportstatus

import io.kotlintest.TestCase
import io.kotlintest.TestResult
import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.verify

class AirportTest : StringSpec() {
    val iah = Airport("IAH", "Houston", true)
    val iad = Airport("IAD", "Dulles", false)
    val ord = Airport("ORD", "Chicago O'Hare", true)
    val error = Airport("ERR", "Invalid airport", false)

    override fun beforeTest(testCase: TestCase) {
        mockkObject(Airport) // 创建 Airport 伴生对象
    }

    override fun afterTest(testCase: TestCase, result: TestResult) {
        clearAllMocks()
    }

    init {
        "canary test should pass" {
            true shouldBe true
        }

        "create Airport" {
            iah.code shouldBe "IAH"
            iad.name shouldBe "Dulles"
            ord.delay shouldBe true
        }

        "sort empty list should return an empty list" {
            Airport.sort(listOf<Airport>()) shouldBe listOf<Airport>()
        }

        "sort airports by name" {
            forall(
                row(listOf(), listOf()),
                row(listOf(iad), listOf(iad)),
                row(listOf(iad, iah), listOf(iad, iah)),
                row(listOf(iad, iah, ord), listOf(ord, iad, iah))
            ) { input, result ->
                Airport.sort(input) shouldBe result
            }
        }

        "getAirportData invokes fetchData" {
            every { Airport.fetchData("IAD") } returns
                    """{"IATA":"IAD", "Name": "Dulles", "Delay": false}"""

            Airport.getAirportData("IAD")

            verify { Airport.fetchData("IAD") } // 测试是否调用
        }

        "getAirportData extracts Airport from JSON returned by fetchData" {
            every { Airport.fetchData("IAD") } returns
                    """{"IATA":"IAD", "Name": "Dulles", "Delay": false}"""

            Airport.getAirportData("IAD") shouldBe iad
            verify { Airport.fetchData("IAD") }
        }

        "getAirportData handles error fetching data" {
            every { Airport.fetchData("EER") } returns "{}"
            Airport.getAirportData("EER") shouldBe error
            verify { Airport.fetchData("EER") }
        }
    }

}