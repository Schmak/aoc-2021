package day07

import utils.readFile
import kotlin.math.abs

fun part1(input: List<Int>): Int = input.distinct().minOf { i ->
    input.sumOf { j -> abs(i - j) }
}

fun parseInput(input: List<String>): List<Int> = input.first().split(",").map(String::toInt)

fun main() {
    val input = parseInput(readFile("07"))
    println(part1(input))
}