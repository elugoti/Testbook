package android.app.testbook.data.repositories

import android.app.testbook.data.network.TestApi
import android.app.testbook.data.responses.CouseListMainResponse
import retrofit2.Response

class CourseRepository {
    suspend fun getCourseList(isPremium : Boolean?,isIncludeIndividual : Boolean ?): Response<CouseListMainResponse> {
        return TestApi().getCoursesList(isPremium,isIncludeIndividual)
    }
}