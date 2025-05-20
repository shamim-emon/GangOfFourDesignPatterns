package behavioral.strategy

interface KycStrategy {
    fun verify(customer: Customer): Boolean
}