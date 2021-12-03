package day03

import utils.readFile

fun part1(input: List<String>): Int = Calculator(input).run { gamma * epsilon }

fun main() {
    val input = readFile("03")
    println(part1(input))
}