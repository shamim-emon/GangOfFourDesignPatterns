package behavioral.state

//Concrete state : Active state
class ActiveState: WalletState {

    private lateinit var overdrawnState: WalletState

    fun setOverdrawnState(state: OverDrawnState) {
        overdrawnState = state
    }

    override fun widthDraw(wallet: DigitalWallet, amount: Double) {
        wallet.withDrawFromWallet(amount)
        if (wallet.getBalance() < 0.0) {
            if(this::overdrawnState.isInitialized){
                println("Balance is negative, switching to overdrawn state")
                wallet.changeWalletState(overdrawnState)
            }else {
                error("overdrawnState not set")
            }

        }
    }

    override fun deposit(wallet: DigitalWallet, amount: Double) {
        wallet.depositIntoWallet(amount)
    }
}

//Concrete state : Overdrawn state
class OverDrawnState : WalletState {
    /*for simplicity, I have initialized this property here
    * Ideally this should be injected
    * */
    private lateinit var activeState: WalletState

    fun setActiveState(state: ActiveState) {
        activeState = state
    }

    override fun widthDraw(wallet: DigitalWallet, amount: Double) {
        println("Can't withdraw money from wallet in overdrawn state. Please deposit money to activate again.")
    }

    override fun deposit(wallet: DigitalWallet, amount: Double) {
        wallet.depositIntoWallet(amount)
        if (wallet.getBalance() > 0.0) {
            if(this::activeState.isInitialized) {
                println("Balance is positive, switching to active state")
                wallet.changeWalletState(activeState)
            }else {
                error("Active state not set.")
            }

        }
    }
}

//Concrete state : Close state
class ClosedState : WalletState {
    override fun widthDraw(wallet: DigitalWallet, amount: Double) {
        println("Can't withdraw money from wallet in closed state. Please  activate again to use wallet.")
    }

    override fun deposit(wallet: DigitalWallet, amount: Double) {
        println("Can't deposit money into wallet in closed state. Please  activate again to use wallet.")
    }
}