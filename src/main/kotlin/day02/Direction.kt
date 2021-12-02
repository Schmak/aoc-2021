package day02

enum class Direction(val dx: Int, val dy: Int) {
    FORWARD(dx = 1, dy = 0),
    UP(dx = 0, dy = -1),
    DOWN(dx = 0, dy = 1)
}