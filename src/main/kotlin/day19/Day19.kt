package day19

import utils.readFile


fun part1(input: List<Scanner>): Int = mergeScanners(input).first.beacons.size

fun part2(input: List<Scanner>): Int {
    val vectors = mergeScanners(input).second
    return vectors.maxOf { a ->
        vectors.maxOf { b -> a.distanceTo(b) }
    }
}

private fun mergeScanners(input: List<Scanner>): Pair<Scanner, List<Vector>> {
    var mergedScanner = input.first()
    val scanners = input.drop(1).toMutableList()
    val shifts = mutableListOf<Vector>()
    while (scanners.isNotEmpty()) {
        var merged = false
        for (scanner in scanners) {
            val pair = mergedScanner.merge(scanner) ?: continue
            mergedScanner = pair.first
            shifts += pair.second
            scanners.remove(scanner)
            merged = true
            break
        }
        require(merged) { "No common beacons found: $mergedScanner\n\n$scanners" }

    }
    return mergedScanner to shifts
}

fun parseInput(input: List<String>): List<Scanner> = buildList {
    var beacons = mutableSetOf<Vector>()
    input.forEach { line ->
        when {
            line.startsWith("---") -> beacons = mutableSetOf()
            line.isEmpty() -> add(Scanner(beacons))
            else -> beacons += Vector.parse(line)
        }
    }
    add(Scanner(beacons))
}

fun main() {
    val input = parseInput(readFile("19"))
    println(part1(input))
    println(part2(input))
}