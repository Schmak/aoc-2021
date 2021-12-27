package day21

import utils.readFile
import kotlin.math.max

fun part1(input: List<Int>): Int {
    val dice = generateSequence(1) { if (it == 100) 1 else it + 1 }.iterator()
    var rolls = 0
    val position = input.toIntArray()
    val score = IntArray(2)
    while (true) {
        for (idx in 0..1) {
            rolls += 3
            val step = List(3) { dice.next() }.sum()
            position[idx] = (position[idx] + step - 1) % 10 + 1
            score[idx] += position[idx]
            if (score[idx] >= 1000)
                return score[1 - idx] * rolls
        }
    }
}

fun part2(input: List<Int>): Long =
    max(
        total(input[0], input[1], 1),
        total(input[1], input[0], 0)
    )

private val rollValues = sequenceOf(1, 2, 3)

private val frequencies = rollValues.flatMap { i ->
    rollValues.flatMap { j ->
        rollValues.map { k -> i + j + k }
    }
}.groupingBy { it }.eachCount()

fun total(firstInitPosition: Int, secondInitPosition: Int, turnDiff: Int): Long =
    (1..10).asSequence().flatMap { firstEndPosition ->
        (1..10).asSequence().flatMap { secondEndPosition ->
            (21..30).asSequence().flatMap { firstScore ->
                (1..20).asSequence().flatMap { secondScore ->
                    (1..10).asSequence().map { turn ->
                        solve(
                            State(
                                position = firstEndPosition,
                                score = firstScore,
                                turn = turn,
                                initPosition = firstInitPosition
                            )
                        ) * solve(
                            State(
                                position = secondEndPosition,
                                score = secondScore,
                                turn = turn - turnDiff,
                                initPosition = secondInitPosition
                            )
                        )
                    }
                }
            }
        }
    }.sum()

private val cache = mutableMapOf<State, Long>()

private fun solve(state: State): Long = cache.getOrPut(state) {
    with(state) {
        if (turn == 0)
            return if (score == 0 && position == initPosition) 1L else 0L

        if (score !in 1 until (21 + position))
            return 0L

        frequencies.entries.sumOf { (amount, freq) ->
            val prevPosition = (position - amount + 9) % 10 + 1
            freq * solve(
                copy(
                    position = prevPosition,
                    turn = turn - 1,
                    score = score - position
                )
            )
        }
    }
}

fun parseInput(input: List<String>): List<Int> =
    input.take(2).map { line -> line.split(":").last().trim().toInt() }

fun main() {
    val input = parseInput(readFile("21"))
    println(part1(input))
    println(part2(input))
}