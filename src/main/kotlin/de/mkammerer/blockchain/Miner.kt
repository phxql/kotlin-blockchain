package de.mkammerer.blockchain

import com.google.common.hash.Hashing
import java.nio.ByteBuffer
import java.util.*

object Miner {
    private val random = Random()

    fun mine(previousBlock: Hash, data: ByteArray, difficulty: Int): Block {
        // Previous block + data + difficulty + nonce
        val payload = ByteBuffer.allocate(Hash.HASH_SIZE + data.size + 4 + 8)
        var iterations = 1L

        while (true) {
            val nonce = random.nextLong()

            payload.put(previousBlock.data)
            payload.put(data)
            payload.putInt(difficulty)
            payload.putLong(nonce)

            val hash = Hashing.sha256().hashBytes(payload.array()).asBytes()
            if (BitUtils.leadingZeroes(hash) >= difficulty) {
                println("Took $iterations iterations")
                return Block(previousBlock, data, nonce, Hash(hash), difficulty)
            }

            payload.flip()
            iterations++
        }
    }
}