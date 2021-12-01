package day01

import utils.readFile

fun part1(input: List<Int>) = input.zipWithNext().count { it.first < it.second }

fun parseInput(lines: List<String>) = lines.map(String::toInt)

fun main() {
    val input = parseInput(readFile("01"))
    println(part1(input))
}