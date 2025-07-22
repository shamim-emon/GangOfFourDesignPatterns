package behavioral.chainOfResponsibility

class SuccessHandler : ResponseHandler() {
    override fun process(response: ApiResponse): Boolean {
        return if (response is ApiResponse.Success<*>) {
            println("SuccessHandler: Processing data: ${response.data}")
            true
        } else false
    }
}

class ClientErrorHandler : ResponseHandler() {
    override fun process(response: ApiResponse): Boolean {
        return if (response is ApiResponse.ClientError) {
            println("ClientErrorHandler: Client error occurred: ${response.message}")
            true
        } else false
    }
}

class ServerErrorHandler : ResponseHandler() {
    override fun process(response: ApiResponse): Boolean {
        return if (response is ApiResponse.ServerError) {
            println("ServerErrorHandler: Server error occurred: ${response.message}")
            true
        } else false
    }
}