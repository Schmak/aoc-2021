package day14

typealias Polymer = Map<String, Long>

class Mutator(private val input: Input) {

    fun calculate(iterations: Int): Long {
        val template =
            input.template.windowed(2).groupingBy { it }.eachCount().mapValues { (_, value) -> value.toLong() }
        val mutated = (1..iterations).fold(template) { acc, _ -> acc.mutated }.map { it.key to it.value }
        val total = (mutated + (input.template.takeLast(1) to 1L))
            .groupingBy { it.first[0] }
            .aggregate { _, acc: Long?, item, _ -> (acc ?: 0) + item.second }
            .values.sorted()
        return total.last() - total.first()
    }

    private val Polymer.mutated: Polymer
        get() = this.entries.flatMap { (chars, total) ->
            val newChar = input.rules[chars]
            if (newChar == null)
                listOf(chars to total)
            else {
                listOf(
                    chars[0] + newChar to total,
                    newChar + chars[1] to total
                )
            }
        }.groupingBy { it.first }
            .aggregate { _, acc, element, _ -> (acc ?: 0) + element.second }
}