package dvp.app.utube.repositories.remote.youtube

import dvp.app.utube.repositories.remote.ResultData
import dvp.app.utube.repositories.remote.youtube.models.BaseResponse
import dvp.app.utube.repositories.remote.youtube.models.VideoResponse
import io.ktor.client.request.*
import kotlinx.coroutines.*


object VideoRequests {
    private const val apiPath = "videos"

    suspend fun getVideos(): ResultData<VideoResponse> {
//        return try {
//            val res = youtubeClient.get<VideoResponse>(path = apiPath) {
//                parameter("part", "snippet,contentDetails,statistics")
//                parameter("chart", "mostPopular")
//                parameter("regionCode", "US")
//            }
//            ResultData.success(res)
//        } catch (e: Exception) {
//            ResultData.failure(e.message ?: "Ops!!! Something when wrong")
//        }
        val restieResult: ResultData<T> = ResultData()
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val makeRequestAsync: Deferred<T?> = GlobalScope.async { return@async makeRequest<T?>() }
                val requestResult: T? = makeRequestAsync.await()
                requestResult?.let { resolvedResult ->
                    restieResult.broadcastSuccess(resolvedResult)
                } ?: run {
                    restieResult.broadcastFailure(Exception("We were not able to resolve the request"))
                }
            } catch (e: Exception) {
                restieResult.broadcastFailure(e)
            }
        }
        return restieResult
    }

    suspend inline fun <reified T : BaseResponse> Get(): ResultData<T> {
        val req = youtubeClient.get<T> {

        }


    }
}