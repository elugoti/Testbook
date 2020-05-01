package android.app.testbook.data.network

import android.app.testbook.data.responses.CourseResponse
import android.app.testbook.data.responses.CouseListMainResponse
import android.app.testbook.utils.Constants
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface TestApi {

    @GET("popular-courses")
    suspend fun getCoursesList(
        @Query ("isPremium") isPremium : Boolean?,
        @Query ("includeIndividual") includeIndividual : Boolean?):Response<CouseListMainResponse>

    companion object{
        operator fun invoke() : TestApi{
            return Retrofit.Builder()
                .baseUrl(Constants.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(TestApi::class.java)
        }
    }
}