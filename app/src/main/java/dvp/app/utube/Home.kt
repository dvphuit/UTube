package dvp.app.utube

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(openVideo: () -> Unit) {
    Column(modifier = Modifier.padding(8.dp)) {

        Button(onClick = {openVideo.invoke()}) {
            Text("Button")
        }
    }
}


@Composable
fun DetailScreen() {
    Column(modifier = Modifier.padding(8.dp)) {
        Text("Detail Screen")
    }
}
