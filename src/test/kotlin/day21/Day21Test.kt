package day21

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.readFile

internal class Day21Test {
    @Test
    fun part1() {
        val actual = part1(input)
        assertThat(actual).isEqualTo(739785)
    }

    @Test
    fun part2() {
        val actual = part2(input)
        assertThat(actual).isEqualTo(444_356_092_776_315)
    }

    companion object {
        private val input = parseInput(readFile("21", type = "test"))
    }
}