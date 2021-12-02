package day02

import utils.readFile

fun part1(input: List<Action>): Int =
    input.fold(State(0, 0, 0)) { state, action -> state + action }
        .let { it.x * it.y }

fun part2(input: List<Action>): Int =
    input.fold(State(0, 0, 0)) { position, action -> position * action }
        .let { it.x * it.y }

fun parseInput(lines: List<String>): List<Action> = lines.map { Action.parse(it) }

fun main() {
    val input = parseInput(readFile("02"))
    println(part1(input))
    println(part2(input))
}