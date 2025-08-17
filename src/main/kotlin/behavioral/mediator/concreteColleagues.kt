package behavioral.mediator

class CreditCheck : Colleague {
    private lateinit var mediator: LoanMediator
    override fun setMediator(mediator: LoanMediator) { this.mediator = mediator }

    fun checkCredit(profile: Profile) {
        println("CreditCheck: Score = ${profile.creditScore}")
        if (profile.creditScore < 600) mediator.notify(ColleagueEvent(profile = profile, status = "CreditRejected"))
        else mediator.notify(ColleagueEvent(profile = profile, status = "CreditOk"))
    }
}

class RiskAssessment : Colleague {
    private lateinit var mediator: LoanMediator
    override fun setMediator(mediator: LoanMediator) { this.mediator = mediator }

    fun assessRisk(profile: Profile) {
        println("RiskAssessment: Income = ${profile.monthlyIncome}")
        if (profile.monthlyIncome < 2000) mediator.notify(ColleagueEvent(profile = profile, status = "HighRisk"))
        else mediator.notify(ColleagueEvent(profile = profile, status = "LowRisk"))
    }
}

class LoanApproval : Colleague {
    private lateinit var mediator: LoanMediator
    override fun setMediator(mediator: LoanMediator) { this.mediator = mediator }

    fun approve(profile: Profile) = println("Loan Approved for ${profile.accId}")
    fun reject(profile: Profile) = println("Loan Rejected for ${profile.accId}")
}