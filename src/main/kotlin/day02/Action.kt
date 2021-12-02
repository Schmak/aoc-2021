package day02

data class Action(
    val direction: Direction,
    val units: Int
) {
    companion object {
        fun parse(string: String): Action {
            val (direction, units) = string.split(" ")
            return Action(
                direction = Direction.valueOf(direction.uppercase()),
                units = units.toInt()
            )
        }
    }
}