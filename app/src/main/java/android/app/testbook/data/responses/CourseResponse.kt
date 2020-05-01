package android.app.testbook.data.responses

import android.app.testbook.data.Class
import kotlinx.serialization.Serializable

@Serializable
class CourseResponse {
    var classes : List<Class> = emptyList<Class>()
}
