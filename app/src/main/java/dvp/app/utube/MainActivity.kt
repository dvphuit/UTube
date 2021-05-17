package dvp.app.utube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dvp.app.utube.ui.theme.UTubeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InitNavHost( )
        }
    }
}


@Composable
fun InitNavHost() {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }

    UTubeTheme {
        NavHost(navController, startDestination = Home) {
            composable(Home) {
                HomeScreen(actions.openVideo)
            }
            composable(VideoDetail) { navBackStackEntry ->
                DetailScreen()
            }
        }
    }
}


@Preview(device = Devices.PIXEL_3, showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    InitNavHost()
}