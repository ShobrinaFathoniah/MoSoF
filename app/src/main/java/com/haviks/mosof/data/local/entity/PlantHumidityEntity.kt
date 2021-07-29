package com.haviks.mosof.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plantHumidity")
data class PlantHumidityEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "no")
    var no: Int,

    @ColumnInfo(name = "humidity")
    var humidity: String
)