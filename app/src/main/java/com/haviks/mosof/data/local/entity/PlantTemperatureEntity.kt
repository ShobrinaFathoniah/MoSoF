package com.haviks.mosof.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plantTemperature")
data class PlantTemperatureEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "no")
    var no: Int,

    @ColumnInfo(name = "temperature")
    var temperature: String
)