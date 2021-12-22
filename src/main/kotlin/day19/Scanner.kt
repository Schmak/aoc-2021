package day19

data class Scanner(
    val beacons: Set<Vector>
) {
    constructor(vararg beacon: Vector) : this(beacons = beacon.toSet())

    val oriented: Sequence<Scanner>
        get() = Matrix.ALL.map { matrix ->
            Scanner(beacons = this.beacons.map { (matrix * it.toMatrix()).toVector() }.toSet())
        }

    fun merge(other: Scanner): Pair<Scanner, Vector>? {
        other.oriented.forEach { secondScanner ->
            beacons.forEach { firstBeacon ->
                secondScanner.beacons.forEach { secondBeacon ->
                    val shift = firstBeacon - secondBeacon
                    val newBeacons = secondScanner.shift(shift).beacons
                    val total = newBeacons.intersect(beacons).size
                    if (total >= 12) {
                        return Scanner(newBeacons + beacons) to shift
                    }
                }
            }
        }
        return null
    }

    fun shift(vector: Vector) = Scanner(
        beacons = beacons.map { it + vector }.toSet()
    )
}
