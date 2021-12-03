package day03

class Calculator(private val values: List<String>) {
    val gamma: Int by lazy { calculateRate(::mostPopular) }

    val epsilon: Int by lazy { calculateRate(::leastPopular) }

    private fun calculateRate(findChar: (List<String>, Int) -> Char): Int {
        val length = requireNotNull(values.firstOrNull()?.length) { "List should not contain empty lines" }
        return (0 until length).joinToString("") { findChar(values, it).toString() }.toInt(2)
    }

    private fun mostPopular(values: List<String>, idx: Int): Char =
        countChars(values, idx).maxByOrNull { it.value }!!.key

    private fun leastPopular(values: List<String>, idx: Int): Char =
        countChars(values, idx).minByOrNull { it.value }!!.key

    private fun countChars(values: List<String>, idx: Int) =
        values.map { it[idx] }.groupingBy { it }.eachCount()
}