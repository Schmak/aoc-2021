package day07

import utils.readFile
import kotlin.math.abs

fun part1(input: List<Int>): Int = input.distinct().minOf { i ->
    input.sumOf { j -> abs(i - j) }
}

fun part2(input: List<Int>): Int = (input.minOf { it }..input.maxOf { it }).minOf { i ->
    input.sumOf { j ->
        val k = abs(i - j)
        k * (k + 1) / 2
    }
}

fun parseInput(input: List<String>): List<Int> = input.first().split(",").map(String::toInt)

fun main() {
    val input = parseInput(readFile("07"))
    println(part1(input))
    println(part2(input))
}