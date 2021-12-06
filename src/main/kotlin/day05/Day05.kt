package day05

import utils.readFile

fun part1(segments: List<Segment>): Int = Field().apply {
    segments.asSequence()
        .filter { it.start.x == it.end.x || it.start.y == it.end.y }
        .forEach(::addSegment)
}.overlapped

fun parseInput(input: List<String>): List<Segment> = input.map { Segment.parse(it) }

fun main() {
    val input = parseInput(readFile("05"))
    println(part1(input))
}