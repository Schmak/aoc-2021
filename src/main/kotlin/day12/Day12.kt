package day12

import utils.readFile

fun part1(graph: Graph): Int {
    val visited = mutableSetOf<String>()
    var total = 0
    fun dfs(vertex: String) {
        if (vertex == "end") {
            total++
            return
        }
        if (vertex.isSmall)
            visited.add(vertex)
        graph.neighbours[vertex].orEmpty()
            .filterNot { it in visited }
            .forEach(::dfs)
        visited.remove(vertex)
    }
    dfs("start")
    return total
}

fun parseInput(input: List<String>) = Graph(input)

private val String.isSmall get() = first().isLowerCase()

fun main() {
    val input = readFile("12")
    println(part1(parseInput(input)))
}