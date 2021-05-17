package dvp.app.utube.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dvp.app.utube.data.remote.VideoApi
import dvp.app.utube.data.remote.api.IVideoApi
import dvp.app.utube.data.remote.buildOkHttpClient
import dvp.app.utube.data.remote.buildRetrofit
import dvp.app.utube.data.remote.youtube.youtubeClient
import io.ktor.client.*
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object YoutubeApiModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return buildOkHttpClient()
    }

    @Provides
    @Singleton
    @ExperimentalSerializationApi
    fun provideVideoApi(okHttpClient: OkHttpClient): VideoApi {
        return buildRetrofit(okHttpClient).create(VideoApi::class.java)
    }
}