package behavioral.chainOfResponsibility

abstract class ResponseHandler {
    private var next: ResponseHandler? = null

    fun handle(response: ApiResponse) {
        if (!process(response)) {
            next?.handle(response)
        }
    }

    fun setNext(next: ResponseHandler) {
        this.next = next
    }

    protected abstract fun process(response: ApiResponse): Boolean
}