import java.util.*

fun main(args: Array<String>) {
    println("Hello, ${args[0]}!")

    val isUnit = println("This is an expression")
    println(isUnit)

    val temperature = 10
    val isHot = if (temperature > 50) true else false // ignore redundant if condition for example.
    println(isHot)
    val message = "You are ${ if (temperature > 50) "fried" else "safe"} fish"
    println("Message: $message")

    feedTheFish()

    println(canAddFish(10.0, listOf(3,3,3))) //---> false
    println(canAddFish(8.0, listOf(2,2,2), hasDecorations = false)) //---> true
    println(canAddFish(9.0, listOf(1,1,3), 3)) //---> false
    println(canAddFish(10.0, listOf(), 7, true)) //---> true
}

fun getDirtySensorReading() = 20

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = getDirtySensorReading()): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)

    println("Today is $day and the fish eat $food")
    shouldChangeWater(day, 20, 50)
    shouldChangeWater(day)
    shouldChangeWater(day, dirty = 50)
    shouldChangeWater(day = "Monday")
    if (shouldChangeWater(day)) {
        println("Change the water today")
    }
}

fun randomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}

fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
//        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
//        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    val currentTotalSize = currentFish.sum()
    val maxSize: Double = if (hasDecorations) tankSize * 0.8 else tankSize
    return maxSize >= currentTotalSize + fishSize
}