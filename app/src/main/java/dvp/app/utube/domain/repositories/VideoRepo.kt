package dvp.app.utube.domain.repositories

import dvp.app.utube.data.remote.response.Video
import kotlinx.coroutines.flow.Flow

interface VideoRepo {
    suspend fun getVideos(page: Int?): List<Video>

    fun getVideoDetail(id: Int): Flow<Video>
}