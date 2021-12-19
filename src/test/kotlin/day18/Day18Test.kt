package day18

import day18.Number.Companion.plus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

@TestInstance(PER_CLASS)
internal class Day18Test {
    @Test
    fun part1() {
        val actual = part1(sumCases().last().numbers)
        assertThat(actual).isEqualTo(4140)
    }

    @ParameterizedTest
    @MethodSource("explodeCases")
    fun explode(case: ExplodeTestCase) {
        val actual = case.pair.exploded
        assertThat(actual).isEqualTo(case.expected)
    }

    @ParameterizedTest
    @MethodSource("sumCases")
    fun sum(case: SumTestCase) {
        val actual = case.numbers.reduce { a, b -> a + b }
        assertThat(actual).isEqualTo(case.expected)
    }

    fun explodeCases() = listOf(
        ExplodeTestCase(
            "[[[[[9,8],1],2],3],4]",
            "[[[[0,9],2],3],4]",
        ),
        ExplodeTestCase(
            "[7,[6,[5,[4,[3,2]]]]]",
            "[7,[6,[5,[7,0]]]]",
        ),
        ExplodeTestCase(
            "[[6,[5,[4,[3,2]]]],1]",
            "[[6,[5,[7,0]]],3]",
        ),
        ExplodeTestCase(
            "[[3,[2,[1,[7,3]]]],[6,[5,[4,[3,2]]]]]",
            "[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]",
        ),
        ExplodeTestCase(
            "[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]",
            "[[3,[2,[8,0]]],[9,[5,[7,0]]]]",
        ),
    )

    fun sumCases() = listOf(
        SumTestCase(
            numbers = listOf("[1,1]", "[2,2]", "[3,3]", "[4,4]"),
            expected = "[[[[1,1],[2,2]],[3,3]],[4,4]]",
        ),
        SumTestCase(
            numbers = listOf("[1,1]", "[2,2]", "[3,3]", "[4,4]", "[5,5]"),
            expected = "[[[[3,0],[5,3]],[4,4]],[5,5]]"
        ),
        SumTestCase(
            numbers = listOf("[1,1]", "[2,2]", "[3,3]", "[4,4]", "[5,5]", "[6,6]"),
            expected = "[[[[5,0],[7,4]],[5,5]],[6,6]]"
        ),
        SumTestCase(
            numbers = listOf(
                "[[[0,[5,8]],[[1,7],[9,6]]],[[4,[1,2]],[[1,4],2]]]",
                "[[[5,[2,8]],4],[5,[[9,9],0]]]",
                "[6,[[[6,2],[5,6]],[[7,6],[4,7]]]]",
                "[[[6,[0,7]],[0,9]],[4,[9,[9,0]]]]",
                "[[[7,[6,4]],[3,[1,3]]],[[[5,5],1],9]]",
                "[[6,[[7,3],[3,2]]],[[[3,8],[5,7]],4]]",
                "[[[[5,4],[7,7]],8],[[8,3],8]]",
                "[[9,3],[[9,9],[6,[4,9]]]]",
                "[[2,[[7,7],7]],[[5,8],[[9,3],[0,2]]]]",
                "[[[[5,2],5],[8,[3,7]]],[[5,[7,5]],[4,4]]]"
            ),
            expected = "[[[[6,6],[7,6]],[[7,7],[7,0]]],[[[7,7],[7,7]],[[7,8],[9,9]]]]",
        )

    )

    data class ExplodeTestCase(
        val pair: Number.Pair,
        val expected: Number
    ) {
        constructor(
            pair: String,
            expected: String,
        ) : this(Number.parse(pair) as Number.Pair, Number.parse(expected))
    }

    data class SumTestCase(
        val numbers: List<Number>,
        val expected: Number
    ) {
        constructor(
            numbers: List<String>,
            expected: String,
        ) : this(numbers.map { Number.parse(it) }, Number.parse(expected))
    }
}