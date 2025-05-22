package behavioral.command

class BankAccount(private var balance: Double) {

    fun deposit(amount: Double) {
        balance += amount
        println("Deposited BDT $amount. New balance: BDT $balance")
    }

    fun withdraw(amount: Double) {
        if (balance >= amount) {
            balance -= amount
            println("Withdrew BDT $amount. New balance: BDT $balance")
        } else {
            println("Insufficient funds")
        }
    }

}