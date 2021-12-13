package day13

import utils.readFile

fun part1(input: Input): Int {
    val instruction = input.instructions[0]
    return instruction.apply(input.dots).size
}

fun part2(input: Input) {
    val dots = input.instructions.fold(input.dots) { dots, instruction -> instruction.apply(dots) }
    val width = dots.maxOf { it.x } + 1
    val height = dots.maxOf { it.y } + 1
    val result = List(height) { MutableList(width) { '.' } }

    dots.forEach { (x, y) -> result[y][x] = '#' }
    result.forEach { println(it.joinToString("")) }
}

fun main() {
    val input = readFile("13")
    println(part1(Input.parse(input)))
    part2(Input.parse(input))
}