package behavioral.command

class WithdrawCommand(private val bankAccount: BankAccount, private val amount: Double) : TransactionCommand {
    override fun execute() {
        bankAccount.withdraw(amount)
    }

    override fun undo() {
        bankAccount.deposit(amount)
    }
}

class DepositCommand(private val bankAccount: BankAccount, private val amount: Double) : TransactionCommand {
    override fun execute() {
        bankAccount.deposit(amount)
    }

    override fun undo() {
        bankAccount.withdraw(amount)
    }
}