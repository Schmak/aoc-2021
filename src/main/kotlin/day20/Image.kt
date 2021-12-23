package day20

data class Image(
    val data: List<CharArray>,
    val defaultPixel: Char
) {
    private val height = data.size
    private val width = data.first().size

    fun transform(lookupData: String) = Image(
        data = List(height + 4) { y ->
            CharArray(width + 4) { x ->
                transformPixel(x - 2, y - 2, lookupData)
            }
        },
        defaultPixel = if (defaultPixel == '.') lookupData.first() else lookupData.last()
    )

    private fun transformPixel(x: Int, y: Int, lookupData: String): Char =
        (y - 1..y + 1).flatMap { sy ->
            (x - 1..x + 1).map { sx ->
                data.getOrNull(sy)?.getOrNull(sx) ?: defaultPixel
            }
        }
            .map { if (it == '#') 1 else 0 }
            .fold(0) { acc, bit -> acc * 2 + bit }
            .let { lookupData[it] }

    override fun toString() = data.joinToString("\n") { it.joinToString("") }
}