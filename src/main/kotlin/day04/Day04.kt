package day04

import day04.Board.Companion.NO_WIN
import utils.readFile

fun parseInput(lines: List<String>) =
    Input(
        numbers = lines.first().split(",").map { it.toInt() },
        boards = lines.drop(1).chunked(6).map { boardLines ->
            Board(
                numbers = boardLines
                    .drop(1)
                    .map {
                        it.split(" ")
                            .filter(String::isNotBlank)
                            .map(String::toInt)
                            .toIntArray()
                    }
                    .toTypedArray()
            )
        }
    )

fun part1(lines: List<String>): Int {
    val input = parseInput(lines)
    input.numbers.forEach { number ->
        input.boards.forEach { board ->
            val result = board.markNumber(number)
            if (result != NO_WIN)
                return number * result
        }
    }
    return 0
}

fun part2(lines: List<String>): Int {
    val input = parseInput(lines)
    input.numbers.forEach { number ->
        val leftBoards = input.boards.filter { !it.win }
        leftBoards.forEach { board ->
            val result = board.markNumber(number)
            if (leftBoards.size == 1 && result != NO_WIN)
                return number * result
        }
    }
    return 0
}

fun main() {
    val lines = readFile("04")
    println(part1(lines))
    println(part2(lines))
}