package day19

data class Vector(
    val x: Int,
    val y: Int,
    val z: Int,
) {
    fun toMatrix() = Matrix(listOf(x), listOf(y), listOf(z))

    infix operator fun minus(other: Vector) = Vector(
        x = x - other.x,
        y = y - other.y,
        z = z - other.z,
    )

    infix operator fun plus(other: Vector) = Vector(
        x = x + other.x,
        y = y + other.y,
        z = z + other.z,
    )

    companion object {
        fun parse(line: String): Vector =
            line.split(",").map(String::toInt).let {
                Vector(it[0], it[1], it[2])
            }
    }
}
