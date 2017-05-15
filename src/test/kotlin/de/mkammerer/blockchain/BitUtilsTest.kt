package de.mkammerer.blockchain


import org.junit.Assert.assertEquals
import org.junit.Test

class BitUtilsTest {
    @Test
    fun test() {
        assertEquals(8, BitUtils.leadingZeroes(0))
        assertEquals(7, BitUtils.leadingZeroes(1))
        assertEquals(6, BitUtils.leadingZeroes(2))
        assertEquals(5, BitUtils.leadingZeroes(4))
        assertEquals(4, BitUtils.leadingZeroes(8))
        assertEquals(3, BitUtils.leadingZeroes(16))
        assertEquals(2, BitUtils.leadingZeroes(32))
        assertEquals(1, BitUtils.leadingZeroes(64))
        assertEquals(0, BitUtils.leadingZeroes(-1)) // 128
        assertEquals(0, BitUtils.leadingZeroes(-127)) // 255
    }

    @Test
    fun testArray() {
        assertEquals(0, BitUtils.leadingZeroes(byteArrayOf(-1)))
        assertEquals(0, BitUtils.leadingZeroes(byteArrayOf(-1, 0)))
        assertEquals(8, BitUtils.leadingZeroes(byteArrayOf(0, -1)))
        assertEquals(32, BitUtils.leadingZeroes(byteArrayOf(0, 0, 0, 0)))
    }
}