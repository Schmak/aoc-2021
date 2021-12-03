package day03

import utils.readFile

fun part1(input: List<String>): Int = Calculator(input).run { gamma * epsilon }

fun part2(input: List<String>): Int = Calculator(input).run { oxygen * co2 }

fun main() {
    val input = readFile("03")
    println(part1(input))
    println(part2(input))
}