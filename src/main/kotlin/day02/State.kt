package day02

data class State(val x: Int, val y: Int) {
    infix operator fun plus(action: Action): State =
        State(
            x = x + action.units * action.direction.dx,
            y = y + action.units * action.direction.dy,
        )
}