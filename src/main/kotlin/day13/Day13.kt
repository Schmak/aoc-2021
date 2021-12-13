package day13

import utils.readFile

fun part1(input: Input): Int {
    val instruction = input.instructions[0]
    return instruction.apply(input.dots).size
}

fun main() {
    val input = readFile("13")
    println(part1(Input.parse(input)))
}