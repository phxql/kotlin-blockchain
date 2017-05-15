package de.mkammerer.blockchain

data class Hash(val data: ByteArray) {
    companion object {
        const val HASH_SIZE = 256 / 8

        val ALL_ZEROES = Hash(ByteArray(HASH_SIZE))
    }
}

data class Block(
        val previousBlock: Hash,
        val data: ByteArray,
        val nonce: Long,
        val hash: Hash,
        val difficulty: Int
) {
    companion object {
        val GENESIS = Block(Hash.ALL_ZEROES, ByteArray(0), 0, Hash.ALL_ZEROES, 0)
    }
}