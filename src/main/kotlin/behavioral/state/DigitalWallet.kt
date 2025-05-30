package behavioral.state

//Context
class DigitalWallet(
    private var balance: Double,
    private var state: WalletState,
    private val closedState: ClosedState
) {

    //region wallet core functionality
    fun withDrawFromWallet(amount: Double) {
        balance -= amount
        println("Withdrawn $amount BDT from wallet, your current Balance:$balance BDT")
    }

    fun depositIntoWallet(amount: Double) {
        balance += amount
        println("Deposited $amount BDT into wallet, your current Balance:$balance BDT")
    }

    fun getBalance(): Double = balance

    fun closeWallet() {
        println("Wallet is switching to closed state. No transaction will be allowed!")
        changeWalletState(closedState)
    }
    //endregion

    fun changeWalletState(state: WalletState) {
        this.state = state
    }

    fun withdraw(amount: Double) {
        state.widthDraw(wallet = this, amount = amount)
    }

    fun deposit(amount: Double) {
        state.deposit(wallet = this, amount = amount)
    }
}