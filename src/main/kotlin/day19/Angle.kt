package day19

enum class Angle(val sin: Int, val cos: Int) {
    ZERO(sin = 0, cos = 1),
    PI_2(sin = 1, cos = 0),
    PI(sin = 0, cos = -1),
    THREE_PI_2(sin = -1, cos = 0)
    ;

    companion object {
        val values: Sequence<Angle> get() = values().asSequence()
    }
}