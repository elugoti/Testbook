package android.app.testbook.data

import kotlinx.serialization.Serializable

@Serializable
data class ClassProperties (
	var classType : ClassType?,
	var seatsAvailsInfo : String?,
	var color : String?
)