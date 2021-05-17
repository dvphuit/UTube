package dvp.app.utube.data.remote.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoResponse (
    val kind: String? = null,
    val etag: String? = null,
    @SerialName("items")
    val videos: List<Video>? = null,
    val nextPageToken: String? = null,
    val pageInfo: PageInfo? = null
)

@Serializable
data class Video (
    val kind: String? = null,
    val etag: String? = null,
    val id: String,
    val snippet: Snippet,
    val contentDetails: ContentDetails? = null,
    val statistics: Statistics? = null
)

@Serializable
data class ContentDetails (
    val duration: String? = null,
    val dimension: String? = null,
    val definition: String? = null,
    val caption: String? = null,
    val licensedContent: Boolean? = null,
    val contentRating: ContentRating? = null,
    val projection: String? = null
)

@Serializable
class ContentRating()

@Serializable
data class Snippet (
    val publishedAt: String,
    val channelId: String? = null,
    val title: String,
    val description: String? = null,
    val thumbnails: Thumbnails,
    val channelTitle: String,
    val tags: List<String>? = null,
    val categoryId: String? = null,
    val liveBroadcastContent: String? = null,
    val localized: Localized? = null,
    val defaultAudioLanguage: String? = null
)

@Serializable
data class Localized (
    val title: String? = null,
    val description: String? = null
)

@Serializable
data class Thumbnails (
    val default: Default,
    val medium: Default,
    val high: Default,
    val standard: Default,
    val maxres: Default
)

@Serializable
data class Default (
    val url: String,
    val width: Long? = null,
    val height: Long? = null
)

@Serializable
data class Statistics (
    val viewCount: String? = null,
    val likeCount: String? = null,
    val dislikeCount: String? = null,
    val favoriteCount: String? = null,
    val commentCount: String? = null
)

@Serializable
data class PageInfo (
    val totalResults: Long? = null,
    val resultsPerPage: Long? = null
)
