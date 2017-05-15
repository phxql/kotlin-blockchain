package de.mkammerer.blockchain

object BitUtils {
    fun leadingZeroes(byte: Byte): Int {
        val unsigned = byte.toInt().and(0xFF)
        return Integer.numberOfLeadingZeros(unsigned) - 3 * 8
    }

    fun leadingZeroes(array: ByteArray): Int {
        var count = 0
        for (byte in array) {
            val countInByte = leadingZeroes(byte)
            if (countInByte < 8) return count + countInByte else count += 8
        }

        return count
    }
}