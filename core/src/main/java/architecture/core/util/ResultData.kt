package architecture.core.util

import architecture.core.base.Entity

sealed class ResultData<out O : Entity> {
    data class OnSuccess<out O : Entity>(val data: O) : ResultData<O>()
    data class OnFailed(val message: String) : ResultData<Nothing>()
    object OnProcessing : ResultData<Nothing>()

    companion object {
        fun <O : Entity> success(data: O): ResultData<O> = OnSuccess(data)
        fun error(msg: String): ResultData<Nothing> = OnFailed(msg)
        fun loading(): ResultData<Nothing> = OnProcessing
    }
}