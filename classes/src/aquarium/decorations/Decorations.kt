package aquarium.decorations

fun main(args: Array<String>) {
    makeDecorations()
}

fun makeDecorations() {
    val d1 = Decorations("granite")
    println(d1) // with data classes, printing the object prints the values of projects in the objects, instead of just the address.

    val d2 = Decorations("slate")
    println(d2)

    val d3 = Decorations("slate")
    println(d3)

    // data classes also implement equals operators, so if all the fields in the object are equal, the object will be equal.
    println(d1.equals(d2)) // false
    println(d2.equals(d3)) // true

    // you can also copy data objects, which creates a new object with the same property values.
    val d4 = d3.copy()
    println(d3)
    println(d4)


    val d5 = Decorations2("crystal", "wood", "diver")
    println(d5)

    // Using decomposition, we can make 3 variables and assign the values to the properties of the object
    // You must use the same number of fields that are in the class.
    // They are assigned in order that they are declared in the class.
    val (rock, wood, diver) = d5
    println(rock)
    println(wood)
    println(diver)
}

data class Decorations(val rocks: String) {}


data class Decorations2(val rocks: String, val wood: String, val diver: String) {}