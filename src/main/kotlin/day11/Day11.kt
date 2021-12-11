package day11

import utils.readFile

fun part1(field: Field): Int = (1..100).sumOf { field.step() }

fun parseInput(input: List<String>) = Field(input.map { it.map(Char::digitToInt).toMutableList() })

fun main() {
    val input = parseInput(readFile("11"))
    println(part1(input))
}