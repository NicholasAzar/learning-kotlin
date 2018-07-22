/**
Exercise: Greetings, Kotlin
Create a main() function that takes an argument representing the time in 24-hour format (values between and including 0 -> 23).

In the main() function, check if the time is before midday (<12), then print "Good morning, Kotlin"; otherwise, print "Good night, Kotlin".

Notes:
Remember that all main() function arguments are Strings, so you will have to convert this argument to an Int before you can apply the check.

Advanced
Try to use Kotlin's string templates to do this in 1 line.
 */
fun main(args: Array<String>) {
    if (args.size != 1) {
        println("Must have an argument representing the time in 24 hours.")
        return
    }
    val timeIn24h = args[0].toIntOrNull()
    if (timeIn24h == null) {
        println("Argument must be an integer.. provided: '${args[0]}'")
        return
    }

    println("Good ${if (timeIn24h < 12) "morning" else "night"}, Kotlin")
}