package day11

import utils.readFile

fun part1(field: Field): Int = (1..100).sumOf { field.step() }

fun part2(field: Field): Int {
    var steps = 0
    while (!field.isZero()) {
        field.step()
        steps++

    }
    return steps
}

fun parseInput(input: List<String>) = Field(input.map { it.map(Char::digitToInt).toMutableList() })

fun main() {
    val input = readFile("11")
    println(part1(parseInput(input)))
    println(part2(parseInput(input)))
}