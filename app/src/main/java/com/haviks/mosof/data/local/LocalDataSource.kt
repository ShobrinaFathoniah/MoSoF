package com.haviks.mosof.data.local

import androidx.lifecycle.LiveData
import com.haviks.mosof.data.local.entity.*
import com.haviks.mosof.data.local.room.PlantDao

class LocalDataSource private constructor(private val plantDao: PlantDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(
            plantDao: PlantDao
        ): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(plantDao)
            }
    }

    fun getHumidity(): LiveData<PlantHumidityEntity> = plantDao.getHumidity()

    fun getTemperature(): LiveData<PlantTemperatureEntity> = plantDao.getTemperature()

    fun getSoilDryness(): LiveData<SoilDrynessEntity> = plantDao.getSoilDryness()

    fun getSoilMoisture(): LiveData<SoilMoistureEntity> = plantDao.getSoilMoisture()

    fun insertHumidity(humid: PlantHumidityEntity) = plantDao.insertHumidity(humid)

    fun insertTemperature(temp: PlantTemperatureEntity) = plantDao.insertTemperature(temp)

    fun insertSoilDryness(dryness: SoilDrynessEntity) = plantDao.insertSoilDryness(dryness)

    fun insertSoilMoisture(moisture: SoilMoistureEntity) = plantDao.insertSoilMoisture(moisture)

    fun getAllPlant(): LiveData<PlantEntity> = plantDao.getAllPlant()

    fun insertPlantName(name: String) = plantDao.insertPlantName(name)
}