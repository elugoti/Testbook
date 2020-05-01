package android.app.testbook.ui

import android.app.testbook.data.Class
import android.app.testbook.data.repositories.CourseRepository
import android.app.testbook.utils.Coroutines
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CourseViewModel :ViewModel(){

    var isPremium : Boolean? = null
    var isIncludeIndividual : Boolean ? = null
    var coursesListLiveData : MutableLiveData<List<Class>> = MutableLiveData()

    fun getCourseList(): MutableLiveData<List<Class>>{
       Coroutines.main {
           var response = CourseRepository().getCourseList(isPremium,isIncludeIndividual)
           if(response.isSuccessful){
               coursesListLiveData.postValue(response?.body()?.data?.classes)
           }else{

           }
       }
        return coursesListLiveData
    }
}