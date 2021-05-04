package dvp.app.utube.ui.components
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import dvp.app.utube.R
import dvp.app.utube.ui.theme.UTubeTheme


@Composable
fun VideoCard (){
    Column {

        Row {
//            Icon(
//                painter = painterResource(id = R.mipmap.ic_launcher),
//                contentDescription = null // decorative element
//            )
            Column {
                Text("Creator")
                Text("3 minutes ago")
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