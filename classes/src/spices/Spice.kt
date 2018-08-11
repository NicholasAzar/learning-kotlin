package spices

import aquarium.Color

// 1. It's easiest (organizationally) if you make a new package, Spices, with a file, Spice, that has a main() function.

fun main(args: Array<String>) {
    // 5. Create an instance of Curry, and print its color. However, color is actually a property common to all spices,
    // so you can move it to the parent class.
    val curry = Curry("spicy")
    println("Curry name: ${curry.name}, spiciness: ${curry.spiciness}, color: ${curry.color}")

    // 3. Create some containers with spices and print out their labels.
    val spiceCabinet = listOf(SpiceContainer(Curry("Yellow Curry", YellowSpiceColor)),
            SpiceContainer(Curry("Red Curry", RedSpiceColor)),
            SpiceContainer(Curry("Green Curry", GreenSpiceColor)))

    for(element in spiceCabinet) println(element.label)
}

// 2. Copy/paste your Spice class code into that new file.
// 3. Make Spice abstract.
// 6. Change your code so that the SpiceColor interface is added to the Spice class and inherited by Curry.
// 2. Make Spice a sealed class.
//     What is the effect of doing this?
//          Can remove the abstract modifier.
//     Why is this useful?
//          Making Spice a sealed class helps keeps all the spices together in one file.
sealed class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor): SpiceColor by color {

    // 5. Spices are processed in different ways before they can be used. Add an abstract method prepareSpice to Spice, and implement it in Curry.
    abstract fun prepareSpice()
}

// 4. Create a subclass, Curry. Curry can have varying levels of spiciness, so we don't want to use the default value, but rather pass in the spiciness value.
// 7. Then add the Grinder interface to the Curry class.
class Curry(spiciness: String, color: SpiceColor = YellowSpiceColor): Spice("curry", spiciness, color), Grinder {

    // 3. Add a color property to Curry of type SpiceColor, and set the default value to YellowSpiceColor.
    // 4. Add SpiceColor as an interface, and let it be by color.

    override fun prepareSpice() {
        grind()
    }

    override fun grind() {}

}

// 6. Curry is ground into a powder, so let's call a method grind(). However, grinding is something that's not unique to curry,
// or even to spices, and it's always done in a grinder. So we can create an Interface, Grinder, that implements the grind() method. Do that now.
interface Grinder {
    fun grind()
}


// ----------------------


// 1. Create an interface, SpiceColor, that has a color property. You can use a String for the color.
interface SpiceColor {
    val color: Color
}

// 2. Create a singleton subclass, YellowSpiceColor, using the object keyword, because all instances of Curry and other
// spices can use the same YellowSpiceColor instance.
object YellowSpiceColor: SpiceColor {
    override val color = Color.YELLOW
}

object RedSpiceColor: SpiceColor {
    override val color = Color.RED
}

object GreenSpiceColor: SpiceColor {
    override val color = Color.GREEN
}



// 1. Create a simple data class, SpiceContainer, that holds one spice.

data class SpiceContainer(val spice: Spice) {

    // 2. Give SpiceContainer a property, label, that is derived from the name of the spice.
    val label = spice.name
}
