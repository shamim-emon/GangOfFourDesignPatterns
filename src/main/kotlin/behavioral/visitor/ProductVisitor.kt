package behavioral.visitor

interface ProductVisitor {
    fun visit(electronics: Electronics)
    fun visit(fruits: Fruits)
    fun visit(vegetables: Vegetables)
    fun visit(clothes: Clothes)
}