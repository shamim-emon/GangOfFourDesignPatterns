package behavioral.strategy

fun main() {
    val localCustomer = Customer(name = "Tareq Hayder", nationalId = "1234567890")
    val foreignCustomer = Customer(name = "Lana Rey", passportNumber = "P987654321")
    val highRiskCustomer = Customer(name = "John Doe", hasBiometricData = true)

    val verifier = KycVerifier(NationalIdKycStrategy())
    println("Alice: ${verifier.verifyCustomer(localCustomer)}")

    verifier.setStrategy(PassportKycStrategy())
    println("Bob: ${verifier.verifyCustomer(foreignCustomer)}")

    verifier.setStrategy(BiometricKycStrategy())
    println("Charlie: ${verifier.verifyCustomer(highRiskCustomer)}")
}