package day06

class Incubator(state: List<Int>) {
    private val state = LongArray(9)
    val total: Long
        get() = state.sum()

    init {
        state.forEach { this.state[it]++ }
    }

    fun nextDay() {
        val zero = state[0]
        for (idx in 0..7)
            state[idx] = state[idx + 1]
        state[8] = zero
        state[6] += zero
    }
}