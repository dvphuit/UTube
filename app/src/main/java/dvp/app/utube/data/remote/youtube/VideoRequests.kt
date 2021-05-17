package dvp.app.utube.data.remote.youtube

import dvp.app.utube.data.remote.ResultData
import dvp.app.utube.data.remote.response.VideoResponse
import io.ktor.client.request.*


object VideoRequests {
    private const val apiPath = "videos"

    suspend fun getVideos(result: (ResultData<VideoResponse>) -> Unit) {
        try {
            result.invoke(ResultData.loading())

            val res = youtubeClient.get<VideoResponse>(path = apiPath) {
                parameter("part", "snippet,contentDetails,statistics")
                parameter("chart", "mostPopular")
                parameter("regionCode", "US")
            }
            result.invoke(ResultData.success(res))
        } catch (e: Exception) {
            ResultData.failure(e.message ?: "Ops!!! Something when wrong")
        }
    }
}