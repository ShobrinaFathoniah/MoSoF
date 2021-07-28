package com.haviks.mosof.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.haviks.mosof.data.local.entity.PlantConditionEntity
import com.haviks.mosof.data.local.entity.PlantNameEntity

@Database(
    entities = [PlantConditionEntity::class, PlantNameEntity::class],
    version = 1,
    exportSchema = false
)
abstract class PlantDatabase : RoomDatabase() {

    abstract fun plantDao(): PlantDao

    companion object {

        @Volatile
        private var INSTANCE: PlantDatabase? = null

        fun getInstance(context: Context): PlantDatabase = INSTANCE ?: synchronized(this) {
            Room.databaseBuilder(
                context.applicationContext,
                PlantDatabase::class.java,
                "plant_database.db"
            ).build().apply {
                INSTANCE = this
            }
        }
    }
}