fun main(args: Array<String>) {
    print("What mood are you in: ")
    val mood = readLine()!!
    println(whatShouldIDoToday(mood))
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24): String {
    return when {
        shouldGoForWalk(mood, weather)-> "go for a walk"
        shouldStayInBed(mood, weather, temperature)-> "stay in bed"
        shouldGoSwimming(temperature)-> "go swimming"
        else -> "Stay home and read."
    }
}

fun shouldGoForWalk(mood: String, weather: String) = mood == "happy" && weather == "sunny"
fun shouldStayInBed(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "sunny" && temperature == 0
fun shouldGoSwimming(temperature: Int) = temperature > 35