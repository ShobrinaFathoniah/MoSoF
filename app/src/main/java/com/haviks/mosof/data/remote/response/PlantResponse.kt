package com.haviks.mosof.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlantResponse(
    @field:SerializedName("")
    val humidity: String? = null,
    @field:SerializedName("")
    val temperature: String? = null,
    @field:SerializedName("")
    val pH: String? = null
) : Parcelable