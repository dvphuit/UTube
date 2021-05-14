package dvp.app.utube

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import dvp.app.utube.Destinations.VideoDetail

object Destinations {
    const val Home = "home"

    const val VideoDetail = "VideoDetail"

    object VideoDetailArgs {
        const val videoId = "videoId"
    }

}

class Actions(navController: NavHostController) {
    val openVideo: () -> Unit = {
        navController.navigate(VideoDetail)
    }

    val navigateUp: () -> Unit = {
        navController.popBackStack()
    }
}