package behavioral.visitor

class Electronics(
    override val name: String,
    override val price: Double,
    val brand: String,
    val warrantyYears: Int,
    val powerUsage: Int // in watts
) : Product {
    override fun accept(visitor: ProductVisitor) = visitor.visit(this)
}

class Fruits(
    override val name: String,
    override val price: Double,
    val brand: String,
    val originCountry: String,
    val isOrganic: Boolean
) : Product {
    override fun accept(visitor: ProductVisitor) = visitor.visit(this)
}

class Vegetables(
    override val name: String,
    override val price: Double,
    val brand: String,
    val shelfLifeDays: Int,
    val isOrganic: Boolean
) : Product {
    override fun accept(visitor: ProductVisitor) = visitor.visit(this)
}

class Clothes(
    override val name: String,
    override val price: Double,
    val brand: String,
    val size: String,
    val material: String
) : Product {
    override fun accept(visitor: ProductVisitor) = visitor.visit(this)
}