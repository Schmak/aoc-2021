package day19

data class Matrix(
    private val data: List<List<Int>>
) {
    val rows = data.size.also {
        require(it > 0) { "Matrix should not be empty" }
    }
    val cols = data.first().size

    init {
        require(data.all { it.size == cols }) { "All rows should have the same size" }
    }

    constructor(vararg row: List<Int>) : this(row.toList())

    operator fun get(idx: Int) = data[idx]

    fun toVector(): Vector {
        require(rows == 3 && cols == 1) { "Matrix should have 3 rows each containing 1 item" }
        return Vector(
            x = data[0][0],
            y = data[1][0],
            z = data[2][0],
        )
    }

    infix operator fun times(matrix: Matrix): Matrix {
        require(cols == matrix.rows) { "Number of columns=$cols in the left matrix should be equal to number of rows=${matrix.rows} in the right one " }
        return Matrix(List(rows) { row ->
            List(matrix.cols) { col ->
                (0 until cols).sumOf { this[row][it] * matrix[it][col] }
            }
        })
    }

    companion object {
        private fun rx(a: Angle) = Matrix(
            listOf(1, 0, 0),
            listOf(0, a.cos, -a.sin),
            listOf(0, a.sin, a.cos),
        )

        private fun ry(a: Angle) = Matrix(
            listOf(a.cos, 0, a.sin),
            listOf(0, 1, 0),
            listOf(-a.sin, 0, a.cos),
        )

        private fun rz(a: Angle) = Matrix(
            listOf(a.cos, -a.sin, 0),
            listOf(a.sin, a.cos, 0),
            listOf(0, 0, 1),
        )

        val ALL: Sequence<Matrix> = Angle.values.flatMap { x ->
            Angle.values.flatMap { y ->
                Angle.values.map { z ->
                    rz(z) * ry(y) * rx(x)
                }
            }
        }.distinct()
    }
}
