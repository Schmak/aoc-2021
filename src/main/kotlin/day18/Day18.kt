package day18

import day18.Number.Companion.plus
import utils.readFile

fun part1(input: List<Number>): Long = input.reduce { a, b -> a + b }.magnitude

fun parseInput(input: List<String>): List<Number> = input.map { Number.parse(it) }

fun main() {
    val input = parseInput(readFile("18"))
    println(part1(input))
}