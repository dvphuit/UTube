package dvp.app.utube.repositories.remote

sealed class ResultData<out T> {

    data class Success<out T>(val value: T) : ResultData<T>()

    data class Failure<out T>(val message: String) : ResultData<T>()

    object Loading : ResultData<Nothing>()

    companion object {

        fun loading(): ResultData<Nothing> = Loading

        fun <T> success(value: T): ResultData<T> = Success(value)

        fun failure(msg: String): ResultData<Nothing> = Failure(msg)

    }

}
