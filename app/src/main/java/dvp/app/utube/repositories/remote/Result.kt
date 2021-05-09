package dvp.app.utube.repositories.remote

import dvp.app.utube.repositories.remote.youtube.models.BaseReponse

sealed class ResultData<out T> {

    data class Success<out T>(val value: T) : ResultData<T>()

    data class Failure<out T>(val message: String) : ResultData<T>()

    data class Loading<out T>(val value: T? = null) : ResultData<T>()

    companion object {

        fun <T> loading(value: T?): ResultData<T> = Loading(value)

        fun <T:BaseReponse> success(value: T): ResultData<T> = Success(value)

        fun <T> failure(error_msg: String): ResultData<T> = Failure(error_msg)

    }

}
