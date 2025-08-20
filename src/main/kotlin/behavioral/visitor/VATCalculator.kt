package behavioral.visitor

class VATCalculator : ProductVisitor {
    var totalVAT = 0.0
        private set // setter is private

    override fun visit(electronics: Electronics) {
        val vat = electronics.price * 0.15
        totalVAT += vat
    }

    override fun visit(fruits: Fruits) {
        val vat = fruits.price * 0.07
        totalVAT += vat
    }

    override fun visit(vegetables: Vegetables) {
        val vat = vegetables.price * 0.05
        totalVAT += vat
    }

    override fun visit(clothes: Clothes) {
        val vat = clothes.price * 0.12
        totalVAT += vat
    }
}