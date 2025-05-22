package behavioral.iterator

class PortfolioIterator(private val assets: List<Asset>) : Iterator<Asset> {
    private var index = 0
    override fun hasNext(): Boolean {
        return index < assets.size
    }

    override fun next(): Asset {
        return assets[index++]
    }
}