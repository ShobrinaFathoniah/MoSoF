package com.haviks.mosof.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.haviks.mosof.data.local.entity.*

@Dao
interface PlantDao {

    @Query("SELECT * FROM plantHumidity")
    fun getHumidity(): LiveData<PlantHumidityEntity>

    @Query("SELECT * FROM plantTemperature")
    fun getTemperature(): LiveData<PlantTemperatureEntity>

    @Query("SELECT * FROM soilDryness")
    fun getSoilDryness(): LiveData<SoilDrynessEntity>

    @Query("SELECT * FROM soilMoisture")
    fun getSoilMoisture(): LiveData<SoilMoistureEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHumidity(humid: PlantHumidityEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTemperature(temp: PlantTemperatureEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSoilDryness(dryness: SoilDrynessEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSoilMoisture(moisture: SoilMoistureEntity)

    @Query("SELECT DISTINCT * FROM plantName, plantHumidity, plantTemperature, soilDryness, soilMoisture where plantName.`no` = plantHumidity.`no` and plantHumidity.`no` = plantTemperature.`no` and plantTemperature.`no` = soilDryness.`no` and soilDryness.`no` = soilMoisture.`no`")
    fun getAllPlant(): LiveData<PlantEntity>

    @Query("Insert into plantName (name) values (:name) ")
    fun insertPlantName(name: String)
}