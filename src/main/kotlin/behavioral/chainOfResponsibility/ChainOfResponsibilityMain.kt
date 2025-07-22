package behavioral.chainOfResponsibility

fun main() {
    //initialize handlers
    val successHandler = SuccessHandler()
    val clientErrorHandler = ClientErrorHandler()
    val serverErrorHandler = ServerErrorHandler()

    //set next handlers to handlers
    successHandler.setNext(clientErrorHandler)
    clientErrorHandler.setNext(serverErrorHandler)


    val responses = listOf(
        ApiResponse.Success(200, "User data"),
        ApiResponse.ClientError(404, "Not found"),
        ApiResponse.ServerError(500, "Internal server error")
    )

    for (response in responses) {
        successHandler.handle(response)
    }
}