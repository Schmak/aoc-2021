package day06

import utils.readFile

fun part1(input: List<Int>): Long = iterate(input, 80)

fun part2(input: List<Int>): Long = iterate(input, 256)

private fun iterate(input: List<Int>, days: Int) =
    Incubator(input).apply { repeat(days) { nextDay() } }.total

fun parseInput(input: List<String>): List<Int> = input.first().split(",").map(String::toInt)

fun main() {
    val input = parseInput(readFile("06"))
    println(part1(input))
    println(part2(input))
}