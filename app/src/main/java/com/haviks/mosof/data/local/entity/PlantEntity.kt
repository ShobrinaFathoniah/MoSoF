package com.haviks.mosof.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plant")
data class PlantEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "no")
    var no: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "humidity")
    var humidity: String,

    @ColumnInfo(name = "temperature")
    var temperature: String,

    @ColumnInfo(name = "pH")
    var pH: String
)