package com.haviks.mosof.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plantCondition")
data class PlantConditionEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "no")
    var no: Int,

    @ColumnInfo(name = "humidity")
    var humidity: String,

    @ColumnInfo(name = "temperature")
    var temperature: String,

    @ColumnInfo(name = "pH")
    var pH: String
)