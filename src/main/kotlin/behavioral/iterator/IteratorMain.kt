package behavioral.iterator

fun main() {
    val portfolio = Portfolio().apply {
        addAsset(Asset("AAPL", "Stock", 15000.0))
        addAsset(Asset("BTC", "Crypto", 12000.0))
        addAsset(Asset("US Treasury", "Bond", 5000.0))
        addAsset(Asset("Vanguard Fund", "Mutual Fund", 8000.0))
    }

    for (asset in portfolio) {
        println("Asset: ${asset.name} (${asset.type}) - \$${asset.valueUSD}")
    }
}