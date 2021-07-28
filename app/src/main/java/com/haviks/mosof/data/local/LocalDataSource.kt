package com.haviks.mosof.data.local

import androidx.lifecycle.LiveData
import com.haviks.mosof.data.local.entity.PlantConditionEntity
import com.haviks.mosof.data.local.entity.PlantEntity
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

    fun getAllPlantCondition(): LiveData<PlantConditionEntity> = plantDao.getAllPlantCondition()

    fun getAllPlant(): LiveData<PlantEntity> = plantDao.getAllPlant()

    fun insertPlantName(name: String) = plantDao.insertPlantName(name)

    fun insertPlantCondition(plant: PlantConditionEntity) = plantDao.insertPlantCondition(plant)
}