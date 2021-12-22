package day19

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

internal class Day19Test {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(79)
    }

    @Test
    fun orientations() {
        val actual = scanner.oriented.toList()
        assertThat(actual).containsExactlyInAnyOrder(
            Scanner(Vector(x = -3, y = -2, z = -1)),
            Scanner(Vector(x = -3, y = -1, z = 2)),
            Scanner(Vector(x = -3, y = 1, z = -2)),
            Scanner(Vector(x = -3, y = 2, z = 1)),

            Scanner(Vector(x = -2, y = -3, z = 1)),
            Scanner(Vector(x = -2, y = -1, z = -3)),
            Scanner(Vector(x = -2, y = 1, z = 3)),
            Scanner(Vector(x = -2, y = 3, z = -1)),

            Scanner(Vector(x = -1, y = -3, z = -2)),
            Scanner(Vector(x = -1, y = -2, z = 3)),
            Scanner(Vector(x = -1, y = 2, z = -3)),
            Scanner(Vector(x = -1, y = 3, z = 2)),


            Scanner(Vector(x = 1, y = -3, z = 2)),
            Scanner(Vector(x = 1, y = -2, z = -3)),
            Scanner(Vector(x = 1, y = 2, z = 3)),
            Scanner(Vector(x = 1, y = 3, z = -2)),

            Scanner(Vector(x = 2, y = -3, z = -1)),
            Scanner(Vector(x = 2, y = -1, z = 3)),
            Scanner(Vector(x = 2, y = 1, z = -3)),
            Scanner(Vector(x = 2, y = 3, z = 1)),

            Scanner(Vector(x = 3, y = -2, z = 1)),
            Scanner(Vector(x = 3, y = -1, z = -2)),
            Scanner(Vector(x = 3, y = 1, z = 2)),
            Scanner(Vector(x = 3, y = 2, z = -1)),
        )
    }

    companion object {
        private val input = parseInput(readFile("19", type = "test"))
        private val scanner = Scanner(beacons = setOf(Vector(1, 2, 3)))
    }
}