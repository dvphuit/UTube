package features.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.ImageLoadState

@Composable
fun NetImage(url: String, modifier: Modifier = Modifier) {
    val painter = rememberCoilPainter(url)
    val state = if (painter.loadState is ImageLoadState.Success)
        State.End
    else State.Start
    ShimmerWrapper(modifier = Modifier.wrapContentSize(), state = state) {
        Image(
            painter = painter,
            contentDescription = "image",
            modifier = modifier,
            contentScale = ContentScale.Crop
        )
    }
}