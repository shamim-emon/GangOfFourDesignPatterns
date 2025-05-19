package structural.decorator

fun main() {
    // order an espresso
    val espresso : Coffee = Espresso()
    //add additional milk
    val milk : CoffeeDecorator = Milk(espresso)
    //add additional sugar
    val sugar: CoffeeDecorator = Sugar(milk)
    //finally add whipped cream
    val myCoffee = WhippedCream(sugar)

    println("Order: ${myCoffee.description()}")
    println("Total cost: \$${myCoffee.cost()}")
}
