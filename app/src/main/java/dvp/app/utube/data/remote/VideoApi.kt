package dvp.app.utube.data.remote

import dvp.app.utube.data.remote.api.IVideoApi
import dvp.app.utube.data.remote.response.Video
import javax.inject.Inject

class VideoApi @Inject internal constructor(private val api: IVideoApi) {
    suspend fun getVideos(): List<Video> {
        return api.fetchVideos(1).body() ?: emptyList()
    }
}