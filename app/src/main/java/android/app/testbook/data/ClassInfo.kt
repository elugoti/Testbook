package android.app.testbook.data

import kotlinx.serialization.Serializable

@Serializable
data class ClassInfo (
	val facultiesImage : String?,
	val classFeature : ClassFeature?
)