package dvp.app.utube.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.ImageLoadState

@Composable
fun NetImage(url: String, modifier: Modifier = Modifier) {
    val painter = rememberCoilPainter(url)
    Box {
        when (painter.loadState) {
            is ImageLoadState.Loading -> {
//                Box(modifier = modifier
//                    .padding(4.dp)
//                    .fillMaxWidth()){
//                    CircularProgressIndicator(Modifier.align(Alignment.Center))
//                }
                Shimmer(modifier = modifier
                    .padding(4.dp)
                    .fillMaxWidth())

            }
            is ImageLoadState.Success -> {
                Image(
                    painter = painter,
                    contentDescription = "image",
                    modifier = modifier,
                    contentScale = ContentScale.Crop
                )
            }
            else -> {
                Shimmer(modifier = modifier
                    .padding(4.dp)
                    .fillMaxWidth())
            }
        }
    }
}