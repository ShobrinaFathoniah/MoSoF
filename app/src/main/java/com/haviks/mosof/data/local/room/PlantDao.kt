package com.haviks.mosof.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.haviks.mosof.data.local.entity.PlantConditionEntity
import com.haviks.mosof.data.local.entity.PlantEntity
import com.haviks.mosof.data.local.entity.PlantNameEntity

@Dao
interface PlantDao {
    @Query("SELECT * FROM plantCondition")
    fun getAllPlantCondition(): LiveData<PlantConditionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlantCondition(plant: PlantConditionEntity)

    @Query("SELECT * FROM plantName, plantCondition where plantName.`no` = plantCondition.`no`")
    fun getAllPlant(): LiveData<PlantEntity>

    @Query("Insert into plantName (name) values (:name) ")
    fun insertPlantName(name: String)
}