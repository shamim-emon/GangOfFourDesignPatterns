package behavioral.strategy

// Concrete Strategy: National ID Verification
class NationalIdKycStrategy : KycStrategy {
    override fun verify(customer: Customer): Boolean {
        println("Verifying using National ID for ${customer.name}")
        return customer.nationalId?.length == 10
    }
}

// Concrete Strategy: Passport Verification
class PassportKycStrategy : KycStrategy {
    override fun verify(customer: Customer): Boolean {
        println("Verifying using Passport for ${customer.name}")
        return customer.passportNumber?.startsWith("P") == true
    }
}

// Concrete Strategy: Biometric Verification
class BiometricKycStrategy : KycStrategy {
    override fun verify(customer: Customer): Boolean {
        println("Verifying using Biometric Data for ${customer.name}")
        return customer.hasBiometricData
    }
}