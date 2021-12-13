package day13

sealed class Instruction() {
    abstract val value: Int
    abstract fun apply(dots: List<Dot>): List<Dot>

    class FoldX(override val value: Int) : Instruction() {
        override fun apply(dots: List<Dot>): List<Dot> =
            dots.map {
                val diff = it.x - value
                if (diff < 0)
                    it
                else
                    it.copy(x = value - diff)
            }.distinct()
    }

    class FoldY(override val value: Int) : Instruction() {
        override fun apply(dots: List<Dot>): List<Dot> =
            dots.map {
                val diff = it.y - value
                if (diff < 0)
                    it
                else
                    it.copy(y = value - diff)
            }.distinct()
    }

    companion object {
        fun parse(string: String): Instruction =
            string.split(" ")[2].split("=").let { (axis, value) ->
                if (axis == "x")
                    FoldX(value.toInt())
                else
                    FoldY(value.toInt())
            }
    }
}
