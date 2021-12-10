package day10

import utils.readFile

private val cost = mapOf(
    ')' to 3,
    ']' to 57,
    '}' to 1197,
    '>' to 25137,
)

fun part1(input: List<ParsedLine>): Int = input.mapNotNull { it.firstIncorrectChar?.let(cost::get) }.sum()

fun parseInput(input: List<String>): List<ParsedLine> = input.map(::ParsedLine)

fun main() {
    val input = parseInput(readFile("10"))
    println(part1(input))
}