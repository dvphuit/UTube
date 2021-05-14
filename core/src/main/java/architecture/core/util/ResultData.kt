package architecture.core.util


sealed class ResultData<out O> {
    data class OnSuccess<out O>(val data: O) : ResultData<O>()
    data class OnFailed(val message: String) : ResultData<Nothing>()
    object OnProcessing : ResultData<Nothing>()

    companion object {
        fun <O> success(data: O): ResultData<O> = OnSuccess(data)
        fun error(msg: String): ResultData<Nothing> = OnFailed(msg)
        fun loading(): ResultData<Nothing> = OnProcessing
    }
}