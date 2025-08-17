package behavioral.mediator

class LoanMediator(
    private val credit: CreditCheck,
    private val risk: RiskAssessment,
    private val approval: LoanApproval
) {
    init {
        credit.setMediator(this)
        risk.setMediator(this)
        approval.setMediator(this)
    }

    fun notify(event: ColleageEvent) {
        when (event.status) {
            "CreditRejected" -> approval.reject(event.profile)
            "CreditOk" -> risk.assessRisk(event.profile)
            "HighRisk" -> approval.reject(event.profile)
            "LowRisk" -> approval.approve(event.profile)
        }
    }
}