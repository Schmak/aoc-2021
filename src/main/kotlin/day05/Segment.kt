package day05

data class Segment(
    val start: Point,
    val end: Point,
) : Iterable<Point> {
    companion object {
        fun parse(string: String): Segment =
            string.split(" -> ").map { Point.parse(it) }.let { Segment(it[0], it[1]) }

    }

    override fun iterator() = PointIterator(start, end)
}