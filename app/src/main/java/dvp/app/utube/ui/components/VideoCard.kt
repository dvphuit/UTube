package dvp.app.utube.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dvp.app.utube.common.NetImage
import dvp.app.utube.models.VideoModel
import dvp.app.utube.repositories.remote.youtube.VideoRequests
import dvp.app.utube.ui.theme.RoundedShapes
import dvp.app.utube.ui.theme.Typography
import dvp.app.utube.ui.theme.UTubeTheme

@Composable
fun VideoCard() {

    val video = VideoModel(
        channelName = "ABCCC",
        channelAvatar = "https://image.freepik.com/free-vector/businessman-character-avatar-isolated_24877-60111.jpg",
        postTime = "3 min ago",
        videoThumb = "https://i.pinimg.com/originals/3b/8a/d2/3b8ad2c7b1be2caf24321c852103598a.jpg"
    )

    VideoRequests.getVideos()

    Column(modifier = Modifier.padding(8.dp)) {
        VideoThumb(url = video.videoThumb)
        Spacer(modifier = Modifier.height(8.dp))
        VideoInfo(
            avatar = video.channelAvatar,
            channel = video.channelName,
            postTime = video.postTime
        )
    }

}

@Composable
private fun VideoThumb(url: String) {
    NetImage(
        url = url,
        modifier = Modifier
            .background(Color.Red, RoundedShapes.large)
            .clip(RoundedShapes.large)
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
            Text(postTime, style = Typography.caption)
        }
    }
}


@Preview(device = Devices.PIXEL_3, showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    UTubeTheme {
        VideoCard()
    }
}