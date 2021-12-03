package day03

class Calculator(private val values: List<String>) {
    val gamma: Int by lazy { calculateRate(::mostPopular) }

    val epsilon: Int by lazy { calculateRate(::leastPopular) }

    val oxygen: Int by lazy { calculateGasRating(values, ::mostPopular) }

    val co2: Int by lazy { calculateGasRating(values, ::leastPopular) }

    private fun calculateRate(findChar: (List<String>, Int) -> Char): Int {
        val length = requireNotNull(values.firstOrNull()?.length) { "List should not contain empty lines" }
        return (0 until length).joinToString("") { findChar(values, it).toString() }.toInt(2)
    }

    private fun calculateGasRating(
        values: List<String>,
        findChar: (List<String>, Int) -> Char,
        idx: Int = 0
    ): Int {
        if (values.size == 1) return values.first().toInt(2)
        val target = findChar(values, idx)
        val filtered = values.filter { it[idx] == target }
        return calculateGasRating(filtered, findChar, idx + 1)
    }

    private fun mostPopular(values: List<String>, idx: Int): Char {
        val total = countChars(values, idx)
        return if (total[1] >= total[0]) '1' else '0'
    }

    private fun leastPopular(values: List<String>, idx: Int): Char {
        val total = countChars(values, idx)
        return if (total[0] <= total[1]) '0' else '1'
    }

    private fun countChars(values: List<String>, idx: Int): List<Int> {
        val map = values.map { it[idx] }.groupingBy { it }.eachCount()
        return listOf(map['0'] ?: 0, map['1'] ?: 0)
    }
}