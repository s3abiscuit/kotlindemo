import _11dsl.*
import _11dsl.DateUtil.Tense.*

val twoDaysAgo = 2 days ago
println(twoDaysAgo)

/*
Sun Oct 22 15:33:07 CST 2023
*/

/*
kotlinc DataUtil.kt -d DataUtil.jar
kotlinc -script -classpath DataUtil.jar date.kts
*/