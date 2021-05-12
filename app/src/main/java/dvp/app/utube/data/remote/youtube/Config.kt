package dvp.app.utube.data.remote.youtube

import dvp.app.utube.data.remote.ktorClient
import io.ktor.client.features.*
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
