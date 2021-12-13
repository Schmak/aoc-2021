package day13

data class Dot(
    val x: Int,
    val y: Int,
) {
    companion object {
        fun parse(string: String): Dot =
            string.split(",").map(String::toInt).let { (x, y) -> Dot(x, y) }
    }
}
