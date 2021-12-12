package day12

class Graph(edges: List<String>) {
    val neighbours = mutableMapOf<String, List<String>>()

    init {
        edges.forEach { edge ->
            val (left, right) = edge.split("-")
            neighbours[left] = neighbours[left].orEmpty() + right
            neighbours[right] = neighbours[right].orEmpty() + left
        }
    }
}