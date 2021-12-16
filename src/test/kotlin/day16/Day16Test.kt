package day16

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

@TestInstance(PER_CLASS)
internal class Day16Test {

    @Test
    fun parseLiteral() {
        val packet = parseInput(listOf("D2FE28"))
        assertThat(packet).isEqualTo(Packet.Literal(version = 6, value = 2021))
    }

    @ParameterizedTest
    @MethodSource("part1Cases")
    fun part1(case: TestCase) {
        val actual = part1(parseInput(listOf(case.hex)))
        assertThat(actual).isEqualTo(case.expected)
    }

    private fun part1Cases() = listOf(
        TestCase("D2FE28", 6),
        TestCase("8A004A801A8002F478", 16),
        TestCase("620080001611562C8802118E34", 12),
        TestCase("C0015000016115A2E0802F182340", 23),
        TestCase("A0016C880162017C3686B18A3D4780", 31),
    )

    data class TestCase(
        val hex: String,
        val expected: Int
    )
}