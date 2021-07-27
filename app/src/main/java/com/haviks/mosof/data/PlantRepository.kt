package com.haviks.mosof.data

import android.content.Context
import com.haviks.mosof.data.local.room.PlantDao
import com.haviks.mosof.data.local.room.PlantDatabase

class PlantRepository(private val plantDao: PlantDao) {
    companion object {

        @Volatile
        private var instance: PlantRepository? = null

        fun getInstance(context: Context): PlantRepository {
            return instance ?: synchronized(this) {
                if (instance == null) {
                    val database = PlantDatabase.getInstance(context)
                    instance = PlantRepository(database.plantDao())
                }
                return instance as PlantRepository
            }

        }
    }
}