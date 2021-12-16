package day16

import day16.Packet.Operator.Type.*
import kotlin.math.max
import kotlin.math.min

typealias BitStream = ArrayDeque<Int>

sealed class Packet {
    abstract val version: Int
    abstract val value: Long

    data class Literal(
        override val version: Int,
        override val value: Long,
    ) : Packet()

    data class Operator(
        override val version: Int,
        val type: Type,
        val packets: List<Packet>
    ) : Packet() {
        enum class Type {
            Sum,
            Product,
            Min,
            Max,
            Gt,
            Lt,
            Eq
        }

        override val value: Long
            get() = when (type) {
                Sum -> reducePackets { a, b -> a + b }
                Product -> reducePackets { a, b -> a * b }
                Min -> reducePackets { a, b -> min(a, b) }
                Max -> reducePackets { a, b -> max(a, b) }
                Gt -> comparePackets { a, b -> a > b }
                Lt -> comparePackets { a, b -> a < b }
                Eq -> comparePackets { a, b -> a == b }
            }

        private fun reducePackets(operation: (Long, Long) -> Long): Long =
            packets.map { it.value }.reduce(operation)

        private fun comparePackets(predicate: (Long, Long) -> Boolean): Long =
            if (predicate(packets[0].value, packets[1].value)) 1 else 0
    }

    companion object {
        fun parse(bitStream: BitStream): Packet = bitStream.readPacket()

        private fun BitStream.readPacket(): Packet {
            val version = readInt(3)
            val type = readInt(3)
            return if (type == 4)
                readLiteral(version)
            else
                readOperator(version, type)
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

        private fun BitStream.readOperator(version: Int, type: Int): Operator {
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
                type = when (type) {
                    0 -> Sum
                    1 -> Product
                    2 -> Min
                    3 -> Max
                    5 -> Gt
                    6 -> Lt
                    7 -> Eq
                    else -> error("Unsupported operator type")
                }
            )
        }

        private fun BitStream.readInt(bits: Int): Int =
            readBits(bits).reduce { acc, bit -> acc * 2 + bit }

        private fun BitStream.readBits(bits: Int): List<Int> = List(bits) { this.removeFirst() }
    }
}
