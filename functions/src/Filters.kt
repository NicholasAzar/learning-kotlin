fun main(args: Array<String>) {
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )

    val sortedCurries = spices.filter { it.contains("curry") }.sortedBy { it.length }
    val cSpices = spices.filter { it.startsWith('c') || it.endsWith('e') }
            .take(3)
            .filter { it.startsWith('c') }
    println("Sorted curries: $sortedCurries")
    println("cSpices: $cSpices")
}