package day20

import utils.readFile

fun part1(input: Input): Int =
    input.image
        .transform(input.lookupTable)
        .transform(input.lookupTable)
        .data.sumOf { row -> row.count { it == '#' } }

fun parseInput(input: List<String>) =
    Input(
        lookupTable = input.first(),
        image = Image(input.drop(2).map { it.toCharArray() }, defaultPixel = '.')
    )

fun main() {
    val input = parseInput(readFile("20"))
    println(part1(input))
}