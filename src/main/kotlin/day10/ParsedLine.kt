package day10

import java.util.*

class ParsedLine(input: String) {
    private val stack = Stack<Char>()
    val firstIncorrectChar: Char? = getFirstIncorrectChar(input, stack)

    companion object {
        private val brackets = mapOf(
            '(' to ')',
            '<' to '>',
            '{' to '}',
            '[' to ']',
        )

        private fun getFirstIncorrectChar(input: String, stack: Stack<Char>): Char? {
            input.forEach { char ->
                when {
                    char in brackets.keys -> stack.push(char)
                    stack.empty() || brackets[stack.pop()] != char -> return char
                }
            }
            return null
        }
    }
}