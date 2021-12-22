package day19

import kotlin.math.abs

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

    fun distanceTo(other: Vector) =
        abs(x - other.x) + abs(y - other.y) + abs(z - other.z)

    companion object {
        fun parse(line: String): Vector =
            line.split(",").map(String::toInt).let {
                Vector(it[0], it[1], it[2])
            }
    }
}
