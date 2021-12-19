package day18

import java.util.*

sealed class Number {
    abstract val magnitude: Long
    val split: Number get() = split().number

    data class Single(val value: Int) : Number() {
        override val magnitude: Long = value.toLong()

        override fun toString(): String = value.toString()
    }

    data class Pair(
        val first: Number,
        val second: Number
    ) : Number() {
        val exploded: Pair
            get() = this.explode().number as Pair

        private fun explode(depth: Int = 0): ExplodeResult {
            if (depth > 3 && first is Single && second is Single)
                return ExplodeResult(Single(0), first.value, second.value, true)
            if (first is Pair) {
                val result = first.explode(depth + 1)
                val number = Pair(result.number, second.addToFirst(result.right))
                if (result.exploded)
                    return ExplodeResult(number, left = result.left, right = 0, exploded = true)
            }
            if (second is Pair) {
                val result = second.explode(depth + 1)
                val number = Pair(first.addToLast(result.left), result.number)
                if (result.exploded)
                    return ExplodeResult(number, left = 0, right = result.right, exploded = true)
            }
            return ExplodeResult(number = this, left = 0, right = 0, exploded = false)
        }

        private fun Number.addToFirst(value: Int): Number =
            when (this) {
                is Single -> Single(this.value + value)
                is Pair -> Pair(first.addToFirst(value), second)
            }

        private fun Number.addToLast(value: Int): Number =
            when (this) {
                is Single -> Single(this.value + value)
                is Pair -> Pair(first, second.addToLast(value))
            }

        override val magnitude: Long
            get() = 3 * first.magnitude + 2 * second.magnitude

        override fun toString() = "[$first,$second]"

        private data class ExplodeResult(
            val number: Number,
            val left: Int,
            val right: Int,
            val exploded: Boolean
        )
    }

    private fun split(): SplitResult = when (this) {
        is Single -> if (value < 10)
            SplitResult(number = this, split = false)
        else
            SplitResult(
                number = Pair(Single(value / 2), Single((value + 1) / 2)),
                split = true
            )
        is Pair -> {
            val first = first.split()
            val second = second.split()
            SplitResult(
                number = Pair(first.number, if (first.split) this.second else second.number),
                split = first.split || second.split
            )
        }
    }

    private data class SplitResult(
        val number: Number,
        val split: Boolean,
    )

    companion object {
        fun parse(string: String): Number {
            val stack = Stack<Number>()
            string.forEach { char ->
                when (char) {
                    in '0'..'9' -> Single(char.digitToInt())
                    ']' -> {
                        val right = stack.pop()
                        Pair(stack.pop(), right)
                    }
                    else -> null
                }?.let(stack::push)
            }
            return stack.pop()
        }

        infix operator fun Number.plus(other: Number): Number {
            var result = Pair(this, other)
            while (true) {
                val exploded = result.exploded
                if (exploded != result) {
                    result = exploded
                    continue
                }
                val split = result.split
                if (split == result)
                    break
                result = split as Pair
            }
            return result
        }
    }
}