package day12

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import utils.readFile

@TestInstance(PER_CLASS)
internal class Day12Test {
    @ParameterizedTest
    @MethodSource("part1Cases")
    fun part1(case: TestCase) {
        val actual = part1(case.file)
        assertThat(actual).isEqualTo(case.expected)
    }

    private fun part1Cases() = listOf(
        TestCase("01", 10),
        TestCase("02", 19),
        TestCase("03", 226),
    )

    private fun part1(name: String) = part1(parseInput(readFile(name, type = "test")))

    data class TestCase(
        val number: String,
        val expected: Int
    ) {
        val file = "12_$number"
    }
}