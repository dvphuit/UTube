package dvp.app.utube.data.remote.api

import dvp.app.utube.data.remote.response.Video
import retrofit2.Response
import retrofit2.http.GET

interface IVideoApi {
    @GET("videos")
    suspend fun fetchVideos(page: Int): Response<List<Video>>
}

