package android.app.testbook.data

import kotlinx.serialization.Serializable


@Serializable
data class ClassFeature (
	val features : List<Features>?
)