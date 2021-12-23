package day21

import utils.readFile

fun part1(input: List<Int>): Int {
    val dice = generateSequence(1) { if (it == 100) 1 else it + 1 }.iterator()
    var rolls = 0
    val position = input.toIntArray()
    val score = IntArray(2)
    while (true) {
        for (idx in 0..1) {
            rolls += 3
            val step = List(3) { dice.next() }.sum()
            position[idx] = (position[idx] + step - 1) % 10 + 1
            score[idx] += position[idx]
            if (score[idx] >= 1000)
                return score[1 - idx] * rolls
        }
    }
}

fun parseInput(input: List<String>): List<Int> =
    input.take(2).map { line -> line.split(":").last().trim().toInt() }

fun main() {
    val input = parseInput(readFile("21"))
    println(part1(input))
}