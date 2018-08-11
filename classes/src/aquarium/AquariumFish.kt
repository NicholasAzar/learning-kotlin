package aquarium

abstract class AquariumFish {
    abstract val color: String
}

// Class shark implements AquariumFish and FishAction
class Shark: AquariumFish(), FishAction {
    override val color = "grey"

    override fun eat() {
        println("hunt and eat fish")
    }
}

// Class Plecostomus implements AquariumFish and FishAction
class Plecostomus: AquariumFish(), FishAction {
    override val color = "gold"

    override fun eat() {
        println("munch on algae")
    }
}

interface FishAction {
    fun eat()
}