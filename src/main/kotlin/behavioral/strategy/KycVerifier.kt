package behavioral.strategy

// Context
class KycVerifier(private var strategy: KycStrategy) {
    fun setStrategy(strategy: KycStrategy) {
        this.strategy = strategy
    }

    fun verifyCustomer(customer: Customer): Boolean {
        return strategy.verify(customer)
    }
}