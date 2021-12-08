package day08

import utils.readFile

private val uniqueLength = setOf(2, 3, 4, 7)
private val segments = ('a'..'g').toSet()
private val digits: Map<Set<Char>, String> =
    listOf("abcefg", "cf", "acdeg", "acdfg", "bcdf", "abdfg", "abdefg", "acf", "abcdefg", "abcdfg")
        .mapIndexed() { idx, str -> str.toSet() to idx.toString() }
        .toMap()


fun part1(input: List<String>): Int =
    input.sumOf { line ->
        line.split(" | ")[1]
            .splitToSequence(" ")
            .map { it.length }
            .count { it in uniqueLength }
    }

fun part2(input: List<String>): Int =
    input.sumOf { line ->
        val replacements = mutableMapOf<Char, Char>()
        val (left, right) = line.split(" | ")
        val sourceDigits = left.split(" ").map { it.toSet() }.groupBy { it.size }

        fun getSingleValue(length: Int) = (sourceDigits.getValue(length).single() - replacements.keys).single()

        val total = left.filter { it != ' ' }.groupingBy { it }.eachCount()
        replacements[total.findValue(6)] = 'b'
        replacements[total.findValue(4)] = 'e'
        replacements[total.findValue(9)] = 'f'
        replacements[getSingleValue(2)] = 'c'
        replacements[getSingleValue(3)] = 'a'
        replacements[getSingleValue(4)] = 'd'
        replacements[(segments - replacements.keys).single()] = (segments - replacements.values).single()
        right.splitToSequence(" ")
            .map { it.map(replacements::getValue).toSet() }
            .map(digits::getValue)
            .joinToString("")
            .toInt()
    }

private fun Map<Char, Int>.findValue(target: Int) =
    this.entries.first { (_, value) -> value == target }.key

fun main() {
    val input = readFile("08")
    println(part1(input))
    println(part2(input))
}