package day19

import utils.readFile


fun part1(input: List<Scanner>): Int {
    var mergedScanner = input.first()
    val scanners = input.drop(1).toMutableList()
    while (scanners.isNotEmpty()) {
        var merged = false
        for (scanner in scanners) {
            mergedScanner = mergedScanner.merge(scanner) ?: continue
            scanners.remove(scanner)
            merged = true
            break
        }
        require(merged) { "No common beacons found: $mergedScanner\n\n$scanners" }

    }
    return mergedScanner.beacons.size
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
}