package day09

import utils.readFile
import kotlin.Int.Companion.MAX_VALUE


fun part1(input: List<List<Int>>): Int =
    input.mapIndexed { y, row ->
        row.filterIndexed { x, value ->
            value < input.getOrMax(x - 1, y) &&
                    value < input.getOrMax(x + 1, y) &&
                    value < input.getOrMax(x, y - 1) &&
                    value < input.getOrMax(x, y + 1)
        }
    }.flatten().sumOf { it + 1 }

private fun List<List<Int>>.getOrMax(x: Int, y: Int) = this.getOrNull(y)?.getOrNull(x) ?: MAX_VALUE

fun parseInput(input: List<String>): List<List<Int>> = input.map { line -> line.map { it.digitToInt() } }

fun main() {
    val input = parseInput(readFile("09"))
    println(part1(input))
}