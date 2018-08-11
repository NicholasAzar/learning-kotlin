package aquarium

// Singletons
object MobyDickWhale {
    val author = "Herman Melville"

    fun jump() {
        // ...
    }
}

// Enums
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00)
}


// Sealed classes can be subclassed, but only inside the file which it's declared

sealed class Seal

class SeaLion: Seal()
class Walrus: Seal()

fun matchSeal(seal: Seal): String {
    return when(seal) {
        is Walrus -> "walrus"
        is SeaLion -> "sea lion" // if i comment this out, kotlin will give compile time error since it can detect all
        // types of seal's. This is because Seal is a sealed class, and all subclasses can only be within this file,
        // kotlin can run some extra checks.
    }
}