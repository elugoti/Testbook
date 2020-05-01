package android.app.testbook.data.responses

import kotlinx.serialization.Serializable

@Serializable
data class CouseListMainResponse (
    var success : String ?,
    var data : CourseResponse ?
)