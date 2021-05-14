package features.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.models.Video

@Composable
fun VideoCard(video: Video) {
    Column(modifier = Modifier.padding(8.dp)) {
        VideoThumb(url = video.snippet.thumbnails.default.url)
        Spacer(modifier = Modifier.height(8.dp))
        VideoInfo(
            avatar = "https://image.freepik.com/free-vector/businessman-character-avatar-isolated_24877-60111.jpg",
            channel = video.snippet.channelTitle,
            postTime = video.snippet.publishedAt
        )
    }

}

@Composable
private fun VideoThumb(url: String) {
    NetImage(
        url = url,
        modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(200.dp)

    )
}

@Composable
private fun VideoInfo(avatar: String, channel: String, postTime: String) {
    Row {
        NetImage(
            url = avatar,
            modifier = Modifier
                .background(Color.Red, CircleShape)
                .width(40.dp)
                .height(40.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(channel)
            Text(postTime)
        }
    }
}