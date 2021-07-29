package com.haviks.mosof.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SoilMoistureResponse(

	@field:SerializedName("visibility")
	val visibility: String? = null,

	@field:SerializedName("last_value")
	val lastValue: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("history")
	val history: Boolean? = null,

	@field:SerializedName("enabled")
	val enabled: Boolean? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("key")
	val key: String? = null,

	@field:SerializedName("username")
	val username: String? = null
) : Parcelable
