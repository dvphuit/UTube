package dvp.app.utube.repositories.remote.models


import kotlinx.serialization.Serializable

@Serializable
data class VideoResponse (
    val kind: String? = null,
    val etag: String? = null,
    val items: List<Item>? = null,
    val nextPageToken: String? = null,
    val pageInfo: PageInfo? = null
)

@Serializable
data class Item (
    val kind: String? = null,
    val etag: String? = null,
    val id: String? = null,
    val snippet: Snippet? = null,
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
    val publishedAt: String? = null,
    val channelId: String? = null,
    val title: String? = null,
    val description: String? = null,
    val thumbnails: Thumbnails? = null,
    val channelTitle: String? = null,
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
    val default: Default? = null,
    val medium: Default? = null,
    val high: Default? = null,
    val standard: Default? = null,
    val maxres: Default? = null
)

@Serializable
data class Default (
    val url: String? = null,
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
