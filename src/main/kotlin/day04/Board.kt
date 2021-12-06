package day04

class Board(
    private val numbers: Array<IntArray>
) {
    private val rows = numbers.size
    private val cols = numbers.first().size

    private val markedRows = IntArray(rows)
    private val markedCols = IntArray(cols)

    private var _win = false

    val win get() = _win

    private val index: Map<Int, Coordinate> = numbers.flatMapIndexed { rowIdx, row ->
        row.mapIndexed { colIdx, item ->
            item to Coordinate(rowIdx, colIdx)
        }
    }.toMap()

    fun markNumber(number: Int): Int {
        val coordinate = index[number] ?: return NO_WIN
        numbers[coordinate.row][coordinate.col] = 0
        if (++markedRows[coordinate.row] == cols || ++markedCols[coordinate.col] == rows) {
            _win = true
            return numbers.sumOf { it.sum() }
        }
        return NO_WIN
    }

    companion object {
        const val NO_WIN = -1
    }
}