package day11

data class Field(
    private val data: List<MutableList<Int>>
) {
    private val height = data.size
    private val width = data[0].size

    fun step(): Int {
        var total = 0
        forEach(::increase)
        forEach { x, y ->
            if (data[y][x] == 10) {
                data[y][x] = 0
                total++
            }
        }
        return total
    }

    private fun increase(x: Int, y: Int) {
        when {
            data[y][x] == 10 -> return
            ++data[y][x] == 10 -> {
                for (tx in x - 1..x + 1)
                    for (ty in y - 1..y + 1)
                        if ((tx != x || ty != y) && tx in 0 until width && ty in 0 until height)
                            increase(tx, ty)
            }
        }
    }

    private fun forEach(action: (x: Int, y: Int) -> Unit) =
        repeat(width) { x ->
            repeat(height) { y -> action(x, y) }
        }
}
