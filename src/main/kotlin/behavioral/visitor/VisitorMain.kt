package behavioral.visitor

fun main() {
    //1. Create a shopping cart with different product types
    val cart: List<Product> = listOf(
        Electronics(name = "Laptop", price = 1000.0, brand = "Dell", warrantyYears = 2, powerUsage = 65),
        Electronics(name = "Smartphone", price = 800.0, brand = "Samsung", warrantyYears = 1, powerUsage = 15),
        Electronics(name = "Headphones", price = 150.0, brand = "Sony", warrantyYears = 1, powerUsage = 5),

        Fruits(name = "Apple", price = 200.0, brand = "FreshFarm", originCountry = "USA", isOrganic = true),
        Fruits(name = "Banana", price = 100.0, brand = "TropicalFarms", originCountry = "Ecuador", isOrganic = false),
        Fruits(name = "Mango", price = 250.0, brand = "GoldenFarms", originCountry = "India", isOrganic = true),

        Vegetables(name = "Potato", price = 100.0, brand = "GreenLeaf", shelfLifeDays = 30, isOrganic = false),
        Vegetables(name = "Carrot", price = 80.0, brand = "VeggieFarm", shelfLifeDays = 20, isOrganic = true),
        Vegetables(name = "Spinach", price = 50.0, brand = "LeafyGreens", shelfLifeDays = 5, isOrganic = true),

        Clothes(name = "T-Shirt", price = 500.0, brand = "H&M", size = "L", material = "Cotton"),
        Clothes(name = "Jeans", price = 1200.0, brand = "Levis", size = "M", material = "Denim"),
        Clothes(name = "Jacket", price = 2500.0, brand = "NorthFace", size = "XL", material = "Polyester")
    )

    //2. Create visitors for discount and VAT calculations
    val discountCalculator = DiscountCalculator()
    val vatCalculator = VATCalculator()

    /*3.
     *  Apply visitors to each product in the cart.
     *  This calculates both discount and VAT for each product
     */
    cart.forEach {
        it.accept(discountCalculator)
        it.accept(vatCalculator)
    }

    //4. Calculate totals
    val totalPrice = cart.sumOf { it.price } // Sum of all product prices before discount and VAT
    val totalDiscount = discountCalculator.totalDiscount // Total discount calculated by DiscountCalculator
    val totalVAT = vatCalculator.totalVAT  // Total VAT calculated by VATCalculator

    //5. Compute final price: Total price minus discount plus VAT
    val finalPrice = totalPrice - totalDiscount + totalVAT

    //6. Print the summary
    println("=== Summary ===")
    println("Total Price (before discount & VAT): $$totalPrice") // Base total
    println("Total Discount: $$totalDiscount") // Discount applied
    println("Total VAT: $$totalVAT") // VAT added
    println("Final Price (after discount + VAT): $$finalPrice") // Final amount to pay
    println("===============")
}