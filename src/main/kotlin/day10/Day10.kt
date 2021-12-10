package day10

import utils.readFile

private val cost = mapOf(
    ')' to 3,
    ']' to 57,
    '}' to 1197,
    '>' to 25137,
)

private val fixCost = cost.keys.withIndex().associate { it.value to it.index + 1 }

fun part1(input: List<ParsedLine>): Int = input.mapNotNull { it.firstIncorrectChar?.let(cost::get) }.sum()

fun part2(input: List<ParsedLine>): Long =
    input.filter { it.firstIncorrectChar == null }
        .map { it.fixedLine.fold(0L) { acc, char -> 5 * acc + fixCost.getOrDefault(char, 0) } }
        .sorted()
        .let { it[it.size / 2] }

fun parseInput(input: List<String>): List<ParsedLine> = input.map(::ParsedLine)

fun main() {
    val input = parseInput(readFile("10"))
    println(part1(input))
    println(part2(input))
}