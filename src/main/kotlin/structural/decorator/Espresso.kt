package structural.decorator

class Espresso : Coffee {
    override fun cost(): Double = 2.0
    override fun description(): String = "Espresso"
}
