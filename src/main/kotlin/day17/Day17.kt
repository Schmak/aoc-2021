package day17

import utils.readFile

private val regex = """target area: x=(-?\d+)\.\.(-?\d+), y=(-?\d+)\.\.(-?\d+)""".toRegex()

fun part1(target: Target): Int =
    simulateAll(target).maxOrNull()!!

fun part2(target: Target): Int =
    simulateAll(target).count()

private fun simulateAll(target: Target) =
    (0..target.x.last).asSequence().flatMap { vx ->
        (target.y.first..-target.y.first).asSequence().map { vy ->
            simulate(vx, vy, target)
        }
    }
        .filterNotNull()

fun parseInput(input: List<String>): Target =
    regex.matchEntire(input.first())!!
        .groupValues
        .drop(1)
        .map { it.toInt() }
        .let {
            Target(
                x = it[0]..it[1],
                y = it[2]..it[3],
            )
        }

private fun simulate(startVx: Int, startVy: Int, target: Target): Int? {
    var (vx, vy) = startVx to startVy
    var (x, y) = 0 to 0
    var maxY = 0
    while (y >= target.y.first && x <= target.x.last) {
        x += vx
        y += vy
        if (y > maxY)
            maxY = y
        if (x in target.x && y in target.y)
            return maxY
        when {
            vx > 0 -> vx--
            vx < 0 -> vx++
            x !in target.x -> return null
        }
        vy--
    }
    return null
}

fun main() {
    val input = parseInput(readFile("17"))
    println(part1(input))
    println(part2(input))
}