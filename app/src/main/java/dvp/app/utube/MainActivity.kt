package dvp.app.utube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import dvp.app.utube.repositories.remote.youtube.VideoRequests
import dvp.app.utube.ui.components.VideoCard
import dvp.app.utube.ui.theme.UTubeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UTubeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    VideoCard()
                }
            }
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