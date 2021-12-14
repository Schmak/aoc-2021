package day14

import utils.readFile

fun part1(input: Input): Long = Mutator(input).calculate(10)

fun main() {
    val input = Input.parse(readFile("14"))
    println(part1(input))
}