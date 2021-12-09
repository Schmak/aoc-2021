package day09

import utils.readFile
import kotlin.Int.Companion.MAX_VALUE


fun part1(input: List<List<Int>>): Int =
    input.mapIndexed { y, row ->
        row.filterIndexed { x, value ->
            value < input.getOrMax(x - 1, y) &&
                    value < input.getOrMax(x + 1, y) &&
                    value < input.getOrMax(x, y - 1) &&
                    value < input.getOrMax(x, y + 1)
        }
    }.flatten().sumOf { it + 1 }

fun part2(input: List<List<Int>>): Int {
    val height = input.size
    val width = input[0].size
    val basins = List(height) { MutableList(width) { 0 } }
    var num = 1

    fun dfs(x: Int, y: Int) {
        if (x !in 0 until width || y !in 0 until height || input[y][x] > 8 || basins[y][x] > 0) return
        basins[y][x] = num
        dfs(x - 1, y)
        dfs(x + 1, y)
        dfs(x, y - 1)
        dfs(x, y + 1)
    }

    repeat(height) { y ->
        repeat(width) { x ->
            dfs(x, y)
            num++
        }
    }
    return basins.flatten()
        .filter { it != 0 }
        .groupingBy { it }.eachCount()
        .values.sortedDescending()
        .take(3)
        .reduce { a, b -> a * b }
}

private fun List<List<Int>>.getOrMax(x: Int, y: Int) = this.getOrNull(y)?.getOrNull(x) ?: MAX_VALUE

fun parseInput(input: List<String>): List<List<Int>> = input.map { line -> line.map { it.digitToInt() } }

fun main() {
    val input = parseInput(readFile("09"))
    println(part1(input))
    println(part2(input))
}