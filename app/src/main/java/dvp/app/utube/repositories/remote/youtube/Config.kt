package dvp.app.utube.repositories.remote.youtube

import dvp.app.utube.repositories.remote.ResultData
import dvp.app.utube.repositories.remote.ktorClient
import dvp.app.utube.repositories.remote.youtube.models.BaseReponse
import dvp.app.utube.repositories.remote.youtube.models.Entity
import dvp.app.utube.repositories.remote.youtube.models.VideoResponse
import io.ktor.client.features.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*

private const val BASE_URL = "www.googleapis.com/youtube/v3"
private const val API_KEY = "AIzaSyChohDKU0aT1-unD3eI1rLPdA1UwcOyMC8"

 val youtubeClient = ktorClient.config {
    defaultRequest {
        url.protocol = URLProtocol.HTTPS
        host = BASE_URL
        parameter("key", API_KEY)
    }
}


class YoutubeClient {

    suspend fun <T : Entity> get(result: (ResultData<T>) -> Unit) = ktorClient.config {
        defaultRequest {
            url.protocol = URLProtocol.HTTPS
            host = BASE_URL
            parameter("key", API_KEY)
        }
        ResponseObserver {
            when (it.status) {
                HttpStatusCode.OK -> result.invoke()
            }
        }
    }
}