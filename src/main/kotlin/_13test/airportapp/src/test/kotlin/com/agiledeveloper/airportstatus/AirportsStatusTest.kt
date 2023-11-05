package com.agiledeveloper.airportstatus

import io.kotlintest.TestCase
import io.kotlintest.TestResult
import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row
import io.mockk.*
import kotlinx.coroutines.*

class AirportsStatusTest : StringSpec() {
    val iad = Airport("IAD", "Dulles", false)
    val iah = Airport("IAH", "Houston", true)
    val inv = Airport("inv", "Invalid Airport", false)

    override fun beforeTest(testCase: TestCase) {
        mockkObject(Airport) // 创建 Airport 伴生对象
        every { Airport.getAirportData("IAD") } returns iad
        every { Airport.getAirportData("IAH") } returns iah
        every { Airport.getAirportData("inv") } returns inv
    }

    override fun afterTest(testCase: TestCase, result: TestResult) {
        clearAllMocks()
    }

    init {
        "getAirportStatus returns status for airports in sorted order" {
            forall(
                row(listOf<String>(), listOf<Airport>()),
                row(listOf("IAD"), listOf(iad)),
                row(listOf("IAD", "IAH", "inv"), listOf(iad, iah, inv)),
                row(listOf("IAH", "inv", "IAD"), listOf(iad, iah, inv))
            ) { input, result ->
                runBlocking { getAirportStatus(input) shouldBe result }
            }
        }

        "getAirportStatus runs in the Dispatcher.IO context" {
            mockkStatic("kotlinx.coroutines.BuildersKt__Builders_commonKt")
            coEvery {
                withContext<List<Airport>>(
                    context = Dispatchers.IO, block = captureCoroutine()
                )
            } answers {
                listOf(iah)
            }

            getAirportStatus(listOf("IAH")) shouldBe listOf(iah)

            coVerify { withContext<List<Airport>>(Dispatchers.IO, block = any()) }
        }

        "getAirportStatus calls getAirportData asynchronously" {

            mockkStatic("kotlinx.coroutines.BuildersKt__Builders_commonKt")

            coEvery {
                any<CoroutineScope>().async<Airport>(
                    context = any(), block = captureCoroutine())
            } answers {
                CompletableDeferred(iad)
            }

            getAirportStatus(listOf("IAD")) shouldBe listOf(iad)

            coVerify {
                any<CoroutineScope>().async<Airport>(context = any(), block = any())
            }
        }
    }


}