package day06

import utils.readFile

fun part1(input: List<Int>): Long = Incubator(input).apply {
    repeat(80) { nextDay() }
}.total

fun parseInput(input: List<String>): List<Int> = input.first().split(",").map(String::toInt)

fun main() {
    val input = parseInput(readFile("06"))
    println(part1(input))
}