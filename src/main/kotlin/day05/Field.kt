package day05

class Field {
    private val state = mutableMapOf<Point, Int>()

    val overlapped: Int
        get() = state.values.count { it > 1 }

    fun addSegment(segment: Segment) {
        for (point in segment)
            state[point] = (state[point] ?: 0) + 1
    }
}