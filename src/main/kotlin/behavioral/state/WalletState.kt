package behavioral.state

//State Interface
interface WalletState {
    fun widthDraw(wallet: DigitalWallet, amount: Double)
    fun deposit(wallet: DigitalWallet, amount: Double)
}