package day01

import utils.readFile

fun part1(input: List<Int>) = input.zipWithNext().count { it.first < it.second }

fun part2(input: List<Int>) = part1(input.windowed(3).map { it.sum() })

fun parseInput(lines: List<String>) = lines.map(String::toInt)

fun main() {
    val input = parseInput(readFile("01"))
    println(part1(input))
    println(part2(input))
}