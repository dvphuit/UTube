package dvp.app.utube.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dvp.app.utube.data.remote.ktorClient
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

@Module
@InstallIn(ActivityComponent::class)
class YoutubeModule {

    @Provides
    fun provideClient(): HttpClient {
        return ktorClient.config {
            defaultRequest {
                url.protocol = URLProtocol.HTTPS
                host = BASE_URL
                parameter("key", API_KEY)
            }
        }
    }

    companion object {
        private const val BASE_URL = "www.googleapis.com/youtube/v3"
        private const val API_KEY = "AIzaSyChohDKU0aT1-unD3eI1rLPdA1UwcOyMC8"
    }
}