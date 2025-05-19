package structural.decorator

abstract class CoffeeDecorator(private val coffee: Coffee) : Coffee {
    override fun cost(): Double = coffee.cost()
    override fun description(): String = coffee.description()
}
