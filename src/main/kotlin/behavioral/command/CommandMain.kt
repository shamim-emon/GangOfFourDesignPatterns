package behavioral.command

fun main() {
    val bankAccount = BankAccount(balance = 500.00)

    val withdrawCommand = WithdrawCommand(bankAccount = bankAccount, amount = 100.00)
    val depositCommand = DepositCommand(bankAccount = bankAccount, amount = 50.00)
    val invoker = TransactionInvoker()

    //execute withdraw command and undo
    invoker.setCommand(withdrawCommand)
    invoker.executeTransaction()
    invoker.undoTransaction()

    //execute deposit command
    invoker.setCommand(depositCommand)
    invoker.executeTransaction()

}