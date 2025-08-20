package behavioral.visitor

class DiscountCalculator : ProductVisitor {
    var totalDiscount = 0.0
     private set // setter is private

    override fun visit(electronics: Electronics) {
        val discountRate = if (electronics.warrantyYears > 1) {
            0.10
        } else {
            0.05
        }
        val discount = electronics.price * discountRate
        totalDiscount += discount
    }

    override fun visit(fruits: Fruits) {
        val discountRate = if (fruits.isOrganic) {
            0.03
        } else {
            0.05
        }
        val discount = fruits.price * discountRate
        totalDiscount += discount
    }

    override fun visit(vegetables: Vegetables) {
        val discountRate = if (vegetables.isOrganic) {
            0.02
        } else {
            0.04
        }
        val discount = vegetables.price * discountRate
        totalDiscount += discount
    }

    override fun visit(clothes: Clothes) {
        val discountRate = if (clothes.material == "Cotton") {
            0.20
        } else {
            0.15
        }
        val discount = clothes.price * discountRate
        totalDiscount += discount
    }
}