package day08

import utils.readFile

private val uniqueLength = setOf(2, 3, 4, 7)

fun part1(input: List<String>): Int =
    input.sumOf { line ->
        line.split(" | ")[1]
            .splitToSequence(" ")
            .map { it.length }
            .count { it in uniqueLength }
    }

fun main() {
    val input = readFile("08")
    println(part1(input))
}