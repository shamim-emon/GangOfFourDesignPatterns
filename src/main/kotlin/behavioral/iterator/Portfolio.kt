package behavioral.iterator

class Portfolio : Iterable<Asset> {
    private val assets = mutableListOf<Asset>()

    fun addAsset(asset: Asset) {
        assets.add(asset)
    }
    override fun iterator(): Iterator<Asset> {
        return PortfolioIterator(assets)
    }
}