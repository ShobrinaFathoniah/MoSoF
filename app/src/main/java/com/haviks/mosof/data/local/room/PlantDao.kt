package com.haviks.mosof.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.haviks.mosof.data.local.entity.PlantEntity

@Dao
interface PlantDao {
    @Query("SELECT * FROM plant")
    fun getAllPlantCondition(): LiveData<PlantEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlant(plant: PlantEntity)
}