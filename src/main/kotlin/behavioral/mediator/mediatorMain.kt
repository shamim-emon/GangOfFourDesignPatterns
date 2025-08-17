package behavioral.mediator

fun main() {
    val credit = CreditCheck()
    val risk = RiskAssessment()
    val approval = LoanApproval()

    val mediator = LoanMediator(credit, risk, approval)

    println("Case 1: Low score  & low risk->Rejected:")
    credit.checkCredit(Profile(accId= "11247328701123",creditScore = 500,monthlyIncome = 2000.00))

    println("Case 2: Good score but high risk->Rejected:")
    credit.checkCredit(Profile(accId= "11247328721123",creditScore = 700,monthlyIncome = 1500.00))

    println("Case 3: Good score & low risk->Approved:")
    credit.checkCredit(Profile(accId= "13247328721123",creditScore = 600,monthlyIncome = 2500.00))
}