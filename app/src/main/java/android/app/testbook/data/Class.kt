package android.app.testbook.data

import kotlinx.serialization.Serializable

@Serializable
class Class (
    val _id : String?,
    val title : String?,
    val titles : String?,
    val slugUrl : String?,
    val courseLogo : String?,
    val classProperties : ClassProperties?,
    val classInfo : ClassInfo?,
    val isPremium : Boolean?
)