import java.util.*

fun main(args: Array<String>) {
    val rollDice = { Random().nextInt(12) + 1 }
    println("Roll dice: ${rollDice()}")

    val rollDiceSides = {sides: Int -> Random().nextInt(sides) + 1}

    val fixedRollDiceSides = {sides: Int -> if (sides == 0) 0 else Random().nextInt(sides) + 1}

    val rollDice2: (Int) -> Int = {sides ->
        if (sides == 0) 0
        else Random().nextInt(sides) + 1
    }

    gamePlay(rollDice2)
}

fun gamePlay(diceRoll: (Int) -> Int) {
    println("Dice roll: ${diceRoll(6)}")
}