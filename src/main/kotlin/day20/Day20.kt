package day20

import utils.readFile

fun part1(input: Input): Int = solve(input, 2)

fun part2(input: Input): Int = solve(input, 50)

private fun solve(input: Input, iterations: Int): Int {
    var image = input.image
    repeat(iterations) {
        image = image.transform(input.lookupTable)
    }
    return image.data.sumOf { row -> row.count { it == '#' } }
}

fun parseInput(input: List<String>) =
    Input(
        lookupTable = input.first(),
        image = Image(input.drop(2).map { it.toCharArray() }, defaultPixel = '.')
    )

fun main() {
    val input = parseInput(readFile("20"))
    println(part1(input))
    println(part2(input))
}