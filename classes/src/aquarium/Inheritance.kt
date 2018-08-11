package aquarium

/*
Difference between abstract classes and interfaces:
    - abstract classes have constructors.. while interfaces cant.

Both interfaces and abstract classes can implement classes:
    - on interfaces, they're "default" implementations
 */

/*
Use interfaces if you have many methods, but one or two default implementations:
 */
interface AquariumAction {
    fun eat()
    fun jump()
    fun clean()
    fun catchFish()
    fun swim() {
        println("swim")
    }
}

/*
Use an abstract class everytime you can't complete a class
 */
interface FishAction2 {
    fun eat()
}
abstract class AquariumFish2: FishAction2 {
    abstract val color: String
    override fun eat() = println("yum")
}

interface FishColor {
    val color: String
}

/*
Although, kotlin provides a better way to do this, by using "interface delegation"
interface delegation lets you add features to a class via composition
composition is when you use an instance of another class, as oppose to inheriting from it.

Lets explore composition
 */

class Plecostomus2(fishColor: FishColor = GoldColor):
        FishAction by PrintingFishAction("a lot of algea"),
        FishColor by fishColor

/*
By adding: "FishColor by GoldColor" every time you call the color method on Plecostomus2, we're delegating the calls to
the GoldColor singleton.

Or even better, we can update the constructor of plecostomus to accept a fish color and default it to gold, but then
delegate the implementation of the FishColor interface to that object if another one gets passed in.
FishColor by fishColor

We can also replace the eat interface method with a delegation to an implementation class with a constructor arg.
 */


fun main(args: Array<String>) {
    delegate()
}

fun delegate() {
    val pleco = Plecostomus2()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

// Object signifies a singleton, only one instance can exist.
object GoldColor: FishColor {
    override val color = "gold"
}

object RedColor: FishColor {
    override val color = "red"
}


class PrintingFishAction(val food: String): FishAction {
    override fun eat() {
        println(food)
    }
}