package day13

data class Input(
    val dots: List<Dot>,
    val instructions: List<Instruction>
) {
    companion object {
        fun parse(input: List<String>): Input {
            val emptyLineIdx = input.indexOf("")
            return Input(
                dots = input.take(emptyLineIdx).map { Dot.parse(it) },
                instructions = input.drop(emptyLineIdx + 1).map { Instruction.parse(it) },
            )
        }
    }
}
