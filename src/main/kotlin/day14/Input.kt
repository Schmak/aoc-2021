package day14

data class Input(
    val template: String,
    val rules: Map<String, String>
) {
    companion object {
        fun parse(input: List<String>) =
            Input(
                template = input[0],
                rules = input.drop(2).associate {
                    val (from, to) = it.split(" -> ")
                    from to to
                }
            )
    }
}
