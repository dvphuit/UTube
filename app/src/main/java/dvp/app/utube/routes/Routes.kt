package dvp.app.utube.routes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(val route: String) {
    object Splash : Screens("splash")
    object Main : Screens("main")
    object Profile : Screens("profile")
    object VideoDetail : Screens("video_detail")
}

sealed class BottomNavPage(val route: String, val icon: ImageVector) {
    object Home : BottomNavPage("home", Icons.Filled.Home)
    object Trending : BottomNavPage("trending", Icons.Filled.ThumbUp)
    object Library : BottomNavPage("library", Icons.Filled.Favorite)
}