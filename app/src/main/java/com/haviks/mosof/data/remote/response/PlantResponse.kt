package com.haviks.mosof.data.remote.response

import com.google.gson.annotations.SerializedName

data class PlantResponse(
    @field:SerializedName("")
    val humidity: String? = null,
    @field:SerializedName("")
    val temperature: String? = null,
    @field:SerializedName("")
    val pH: String? = null
)