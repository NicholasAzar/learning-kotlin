fun main(args: Array<String>) {
    printHello()

    basicOperations()

    variables()

    nullability()

    nullabilityLists()

    println("Null Checks: " + nullChecks())

    stringTemplate()

    whenStatement()

    loopingOverArrays()
}

fun printHello() {
    println("Hello, world!")
}


/**
 * Practice Time: Basic Operations
 * Solve the following using the operator methods in one line of code.
 *
 * If you start with 2 fish, and they breed twice, producing 71 offspring the first time, and 233 offspring the second time, and then 13 fish are swallowed by a hungry moray eel, how many fish do you have left? How many aquariums do you need if you can put 30 fish per aquarium?
 *
 * Hint: You can chain method calls.
 * Hint: You can call the methods on numbers, and Kotlin will convert them to objects for you.
 * Bonus question: What is special about all the numbers of fish? all fish numbers are prime.
 */
fun basicOperations() {
    val fish = 2.plus(71).plus(233).minus(13)
    println("$fish are left")

    val aquariums = fish.div(30).plus(1)
    println("$aquariums aquariums")
}

/**
 * Practice Time: Variables
 * Create a String variable rainbowColor, set its color value, then change it.
 * Create a variable blackColor whose value cannot be changed once assigned. Try changing it anyway.
 */
fun variables() {
    var rainbowColor = "rainbow"
    rainbowColor = "red"
    println("Rainbow color: $rainbowColor")
    val blackColor = "black"
    // blackColor = "not black" // fails
    println("Black color: $blackColor")
}

/**
 * Practice Time: Nullability
 * Try to set rainbowColor to null. Declare two variables, greenColor and blueColor. Use two different ways of setting them to null.
 */
fun nullability() {
    var rainbowColor = "rainbow"
    // rainbowColor = null // fails
    var greenColor: String? = null
    var blueColor = null
}


/**
 * Practice Time: Nullability/Lists
 * Create a list with two elements that are null; do it in two different ways.
 * Next, create a list where the list is null.
 */
fun nullabilityLists() {
    val myFirstList: List<String?> = listOf(null, null)
    val mySecondList: List<String>? = null
}

/**
 * Practice Time: Null Checks
 * Create a nullable integer variable called nullTest, and set it to null. Use a null-check that increases the value by one if it's not null, otherwise returns 0, and prints the result.
 * Hint: Use the Elvis operator.
 */
fun nullChecks():Int {
    val nullTest: Int? = null
    return nullTest?.inc() ?: 0
}

/**
 * Practice Time
 * Create three String variables for trout, haddock, and snapper.
 * Use a String template to print whether you do or don't like to eat these kinds of fish.
 */
fun stringTemplate() {
    val trout = "Trout"
    val haddock = "Haddock"
    val snapper = "Snapper"

    println("I like to eat $trout, $haddock, and $snapper!")
}


/**
 * Practice Time
 * when statements in Kotlin are like case or switch statements in other languages.
 *
 * Create a when statement with three comparisons:
 *
 * If the length of the fishName is 0, print an error message.
 * If the length is in the range of 3...12, print "Good fish name".
 * If it's anything else, print "OK fish name".
 */
fun whenStatement() {
    val fishName = "Tuna"

    when (fishName.length) {
        0 -> println("Error: fish name is empty.")
        in 3..12 -> println("Good fish name")
        else -> println("OK fish name")
    }
}


/**
 * Practice Time
 * Looping over arrays and lists is a fundamental technique that has a lot of flexibility in Kotlin. Let's practice.
 *
 * Basic example
 * Create an integer array of numbers called numbers, from 11 to 15.
 * Create an empty mutable list for Strings.
 * Write a for loop that loops over the array and adds the string representation of each number to the list.
 *
 * Challenge example
 * How can you use a for loop to create (a list of) the numbers between 1 and 100 that are divisible by 7?
 */
fun loopingOverArrays() {
    val numbers = Array(5) { it + 11 }
    val strings = mutableListOf<String>()

    for (number in numbers) {
        strings.add(number.toString())
    }

    println(strings)

    val divisibleBySeven = mutableListOf<String>()
    for (number in 7..100 step 7) {
        divisibleBySeven.add(number.toString())
    }
    println(divisibleBySeven)
}