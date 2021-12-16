package day16

typealias BitStream = ArrayDeque<Int>

sealed class Packet {
    abstract val version: Int

    data class Literal(
        override val version: Int,
        val value: Long,
    ) : Packet()

    data class Operator(
        override val version: Int,
        val packets: List<Packet>
    ) : Packet()

    companion object {
        fun parse(bitStream: BitStream): Packet = bitStream.readPacket()

        private fun BitStream.readPacket(): Packet {
            val version = readInt(3)
            val type = readInt(3)
            return if (type == 4)
                readLiteral(version)
            else
                readOperator(version)
        }

        private fun BitStream.readLiteral(version: Int): Literal {
            var last = false
            var value = 0L
            while (!last) {
                last = readInt(1) == 0
                value = value * 16 + readInt(4)
            }
            return Literal(version, value)
        }

        private fun BitStream.readOperator(version: Int): Operator {
            val lengthTypeId = readInt(1)
            val packets = if (lengthTypeId == 1)
                List(readInt(11)) { parse(this) }
            else {
                val subPacketsStream = ArrayDeque(readBits(readInt(15)))
                buildList {
                    while (subPacketsStream.isNotEmpty())
                        add(subPacketsStream.readPacket())
                }
            }
            return Operator(
                version = version,
                packets = packets,
            )
        }

        private fun BitStream.readInt(bits: Int): Int =
            readBits(bits).reduce { acc, bit -> acc * 2 + bit }

        private fun BitStream.readBits(bits: Int): List<Int> = List(bits) { this.removeFirst() }
    }
}
