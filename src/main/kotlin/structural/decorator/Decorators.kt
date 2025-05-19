package structural.decorator

class Milk(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost(): Double = super.cost() + 0.5
    override fun description(): String = super.description() + ", Milk"
}

class Sugar(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost(): Double = super.cost() + 0.2
    override fun description(): String = super.description() + ", Sugar"
}

class WhippedCream(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost(): Double = super.cost() + 0.7
    override fun description(): String = super.description() + ", Whipped Cream"
}
