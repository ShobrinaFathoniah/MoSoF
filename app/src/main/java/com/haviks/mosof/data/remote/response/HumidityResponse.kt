package com.haviks.mosof.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HumidityResponse(

	@field:SerializedName("owner")
	val owner: Owner? = null,

	@field:SerializedName("visibility")
	val visibility: String? = null,

	@field:SerializedName("unit_symbol")
	val unitSymbol: String? = null,

	@field:SerializedName("last_value")
	val lastValue: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("groups")
	val groups: List<GroupsItem?>? = null,

	@field:SerializedName("history")
	val history: Boolean? = null,

	@field:SerializedName("unit_type")
	val unitType: String? = null,

	@field:SerializedName("enabled")
	val enabled: Boolean? = null,

	@field:SerializedName("writable")
	val writable: Boolean? = null,

	@field:SerializedName("wipper_pin_info")
	val wipperPinInfo: String? = null,

	@field:SerializedName("license")
	val license: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("key")
	val key: String? = null,

	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("group")
	val group: Group? = null
) : Parcelable

@Parcelize
data class GroupsItem(

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("key")
	val key: String? = null
) : Parcelable

@Parcelize
data class Owner(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("username")
	val username: String? = null
) : Parcelable

@Parcelize
data class Group(

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("key")
	val key: String? = null
) : Parcelable
