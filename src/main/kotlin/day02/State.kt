package day02

import day02.Direction.*

data class State(
    val x: Int,
    val y: Int,
    val aim: Int,
) {
    infix operator fun plus(action: Action): State =
        copy(
            x = x + action.units * action.direction.dx,
            y = y + action.units * action.direction.dy,
        )

    infix operator fun times(action: Action): State = when (action.direction) {
        UP, DOWN -> copy(aim = aim + action.direction.dy * action.units)
        FORWARD ->
            copy(
                x = x + action.units * action.direction.dx,
                y = y + action.units * action.direction.dx * aim
            )
    }
}