package day16

import utils.readFile

fun part1(packet: Packet): Int = packet.versionSum

fun parseInput(input: List<String>): Packet =
    Packet.parse(
        input.first()
            .flatMap {
                it.toString()
                    .toInt(16)
                    .toString(2)
                    .padStart(4, '0')
                    .toList()
            }.mapTo(ArrayDeque(), Char::digitToInt)
    )

private val Packet.versionSum: Int
    get() = version + when (this) {
        is Packet.Literal -> 0
        is Packet.Operator -> packets.sumOf { it.versionSum }
    }

fun main() {
    val input = parseInput(readFile("16"))
    println(part1(input))
}