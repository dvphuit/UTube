package dvp.app.utube.data.remote

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

const val TIMEOUT = 20L

fun buildOkHttpClient(): OkHttpClient {
//    val loggingInterceptor = HttpLoggingInterceptor()
//    loggingInterceptor.level =
//        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.BASIC

    return OkHttpClient.Builder()
        .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(YoutubeApiKey())
        .build()
}

@ExperimentalSerializationApi
fun buildRetrofit(httpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("www.googleapis.com/youtube/v3")
        .addConverterFactory(Json.asConverterFactory(MediaType.parse("application/json")!!))
        .client(httpClient)
        .build()
}


class YoutubeApiKey : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .header("key", "AIzaSyChohDKU0aT1-unD3eI1rLPdA1UwcOyMC8")
            .build()
        return chain.proceed(request)
    }
}