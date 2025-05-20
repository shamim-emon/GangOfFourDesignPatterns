package behavioral.strategy

data class Customer(
    val name: String,
    val nationalId: String? = null,
    val passportNumber: String? = null,
    val hasBiometricData: Boolean = false
)