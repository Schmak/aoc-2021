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

fun part2(graph: Graph): Int {
    val visited = mutableMapOf<String, Int>()
    var total = 0
    fun dfs(vertex: String) {
        if (visited.values.filter { it > 1 }.size > 1 || visited.values.any { it > 2 })
            return
        if (vertex == "end") {
            total++
            return
        }
        if (vertex.isSmall)
            visited[vertex] = visited.getOrDefault(vertex, 0) + 1
        graph.neighbours[vertex].orEmpty()
            .filter { it != "start" }
            .forEach(::dfs)
        if (vertex.isSmall)
            visited[vertex] = visited[vertex]!! - 1
    }
    dfs("start")
    return total
}

fun parseInput(input: List<String>) = Graph(input)

private val String.isSmall get() = first().isLowerCase()

fun main() {
    val input = readFile("12")
    println(part1(parseInput(input)))
    println(part2(parseInput(input)))
}