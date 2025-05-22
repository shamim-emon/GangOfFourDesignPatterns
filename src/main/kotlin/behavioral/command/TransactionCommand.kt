package behavioral.command

interface TransactionCommand {
    fun execute()
    fun undo()
}