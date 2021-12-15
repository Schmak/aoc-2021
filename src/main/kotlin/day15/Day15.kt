package day15

import utils.readFile
import java.util.*

fun part1(input: List<List<Int>>): Int {
    val height = input.size
    val width = input[0].size
    val cost = Array(height) { IntArray(width) { Int.MAX_VALUE } }
    val queue = PriorityQueue<Position>(compareBy { cost[it.y][it.x] })

    fun add(x: Int, y: Int, value: Int) {
        val newCost = value + input[y][x]
        if (newCost < cost[y][x]) {
            cost[y][x] = newCost
            queue.remove(Position(x, y))
            queue.add(Position(x, y))
        }
    }

    cost[0][0] = 0
    queue.add(Position(0, 0))
    while (true) {
        val (x, y) = queue.poll()
        val value = cost[y][x]
        if (x == width - 1 && y == height - 1) return value
        if (x > 0) add(x - 1, y, value)
        if (x < width - 1) add(x + 1, y, value)
        if (y > 0) add(x, y - 1, value)
        if (y < height - 1) add(x, y + 1, value)
    }
}

fun parseInput(input: List<String>): List<List<Int>> = input.map { it.map(Char::digitToInt) }

fun main() {
    val input = parseInput(readFile("15"))
    println(part1(input))
}