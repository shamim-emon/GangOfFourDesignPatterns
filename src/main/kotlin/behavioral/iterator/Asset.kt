package behavioral.iterator

data class Asset(
    val name: String,
    val type: String, // e.g., "Stock", "Bond", "Crypto"
    val valueUSD: Double
)