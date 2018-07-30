package aquarium

import sun.security.provider.ConfigFile

class SimpleSpice {
    var name: String = "curry"
    var spiceLevel: String = "mild"
    val heat: Int
        get() = when (spiceLevel) {
            "mild" -> 5
            else -> -1
        }
}

fun main(args: Array<String>) {
//    val simpleSpice = SimpleSpice()
//    println("Name: ${simpleSpice.name} " +
//            "Heat: ${simpleSpice.heat}")

    val spices = listOf(Spice("curry", "mild"),
            Spice("pepper", "hot"),
            Spice("cayenne", "very hot"),
            Spice("ginger", "mild"),
            Spice("red curry", "hot"),
            Spice("green curry", "mild"),
            Spice("red pepper", "hot" ))


    val hotSpices = spices.filter { it.heat >= 7 }
    println("# of hot spices: ${hotSpices.size}")

    val mildSpices = spices.filter { it.heat < 7 }
    println("# of mild spices: ${hotSpices.size}")
}

class Spice(val name: String, val spiciness: String = "mild") {

    val heat: Int
        get() = when (spiciness) {
            "very hot" -> 10
            "hot" -> 7
            "mild" -> 5
            else -> 0
        }

    init {
        println("Spice name: ${this.name}, spiciness: ${this.spiciness}, heat: ${this.heat}")
    }
}

fun makeSalt() = Spice("salt", "mild")