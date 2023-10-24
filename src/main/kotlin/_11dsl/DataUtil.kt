package _11dsl

import java.util.Calendar
import _11dsl.DateUtil.Tense.*

infix fun Int.days(timing: DateUtil.Tense) = DateUtil(this, timing)

class DateUtil(val number: Int, val tense: Tense) {
    enum public class Tense {
        ago, from_now
    }

    override fun toString(): String {
        val today = Calendar.getInstance()
        return when (tense) {
            Tense.ago -> {
                today.add(Calendar.DAY_OF_MONTH, -number)
                today.time.toString()
            }

            Tense.from_now -> {
                today.add(Calendar.DAY_OF_MONTH, number)
                today.time.toString()
            }
        }
    }
}

