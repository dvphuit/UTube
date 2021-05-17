package dvp.app.utube.domain.usecases

import dvp.app.utube.domain.repositories.VideoRepo
import javax.inject.Inject

class VideoUseCase @Inject constructor(private val repo: VideoRepo) {
    suspend operator fun invoke(page: Int) = repo.getVideos(page.takeIf { it > 0 })
}