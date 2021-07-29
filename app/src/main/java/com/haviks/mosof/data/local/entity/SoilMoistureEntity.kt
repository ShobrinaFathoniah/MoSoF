package com.haviks.mosof.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "soilMoisture")
data class SoilMoistureEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "no")
    var no: Int,

    @ColumnInfo(name = "soilMoisture")
    var soilMoisture: String
)