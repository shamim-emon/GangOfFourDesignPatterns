package behavioral.chainOfResponsibility

sealed class ApiResponse(val code: Int) {
    class Success<T>(code: Int, val data: T) : ApiResponse(code)
    class ClientError(code: Int, val message: String) : ApiResponse(code)
    class ServerError(code: Int, val message: String) : ApiResponse(code)
}