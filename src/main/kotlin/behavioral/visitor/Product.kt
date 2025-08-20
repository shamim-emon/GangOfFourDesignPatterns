package behavioral.visitor

interface Product {
    val name: String
    val price: Double
    fun accept(visitor: ProductVisitor)
}