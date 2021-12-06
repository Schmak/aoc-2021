package day05

import kotlin.math.sign

class PointIterator(
    start: Point,
    private val end: Point,
) : Iterator<Point> {
    private var hasNext = true
    private var current = start

    override fun hasNext() = hasNext

    override fun next(): Point = current.also {
        hasNext = current != end
        current = current.copy(
            x = current.x + (end.x - current.x).sign,
            y = current.y + (end.y - current.y).sign
        )
    }
}