package day05

data class Point(
    val x: Int,
    val y: Int,
) {
    companion object {
        fun parse(string: String): Point =
            string.split(",").map { it.toInt() }.let { Point(it[0], it[1]) }
    }
}