package behavioral.state

fun main() {
    val activeState = ActiveState()
    val overDrawnState = OverDrawnState()
    val closedState = ClosedState()

    activeState.setOverdrawnState(overDrawnState)
    overDrawnState.setActiveState(activeState)

    val wallet = DigitalWallet(balance = 500.00, state = activeState, closedState = closedState)
    wallet.withdraw(amount = 100.00) // success
    wallet.withdraw(amount = 410.00) // success - going to overdrawn state
    wallet.withdraw(amount = 100.00) // can't withdraw

    wallet.deposit(amount = 510.00) // success - as balance is greater than zero, going to active state
    wallet.withdraw(amount = 100.00) // success
    wallet.closeWallet() // closed state
    wallet.withdraw(amount = 100.00) // failure as wallet is closed
    wallet.deposit(amount = 100.00) // failure as wallet is closed
}