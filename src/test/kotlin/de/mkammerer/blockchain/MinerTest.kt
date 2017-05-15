package de.mkammerer.blockchain

import org.junit.Test

class MinerTest {
    private val DIFFICULTY = 16

    @Test
    fun mine() {
        val block1 = Miner.mine(Block.GENESIS.hash, ByteArray(0), DIFFICULTY)
        val block2 = Miner.mine(block1.hash, ByteArray(0), DIFFICULTY)
        val block3 = Miner.mine(block2.hash, ByteArray(0), DIFFICULTY)
        val block4 = Miner.mine(block3.hash, ByteArray(0), DIFFICULTY)
        val block5 = Miner.mine(block4.hash, ByteArray(0), DIFFICULTY)

        println(block1)
        println(block2)
        println(block3)
        println(block4)
        println(block5)
    }
}