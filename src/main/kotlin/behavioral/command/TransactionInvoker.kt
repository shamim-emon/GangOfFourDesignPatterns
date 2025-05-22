package behavioral.command

class TransactionInvoker {
    private lateinit var command: TransactionCommand

    fun setCommand(command: TransactionCommand) {
        this.command = command
    }

    fun executeTransaction() {
        if (!this::command.isInitialized) throw RuntimeException("Command not set")
        command.execute()
    }

    fun undoTransaction() {
        if (!this::command.isInitialized) throw RuntimeException("Command not set")
        command.undo()
    }
}