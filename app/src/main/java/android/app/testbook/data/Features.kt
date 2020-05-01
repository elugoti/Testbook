package android.app.testbook.data

import kotlinx.serialization.Serializable

@Serializable
data class Features (
	val type : String?,
	val count : Int?
)