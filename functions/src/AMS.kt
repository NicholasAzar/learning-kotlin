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
}

fun feedTheFish() {
    val day = "Tuesday"
    val food = "pellets"
}