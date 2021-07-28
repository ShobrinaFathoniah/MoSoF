package com.haviks.mosof.di

import android.content.Context
import com.haviks.mosof.data.PlantRepository
import com.haviks.mosof.data.local.LocalDataSource
import com.haviks.mosof.data.local.room.PlantDatabase
import com.haviks.mosof.data.remote.RemoteDataSource
import com.haviks.mosof.utilis.AppExecutors

object Injection {

    fun plantRepository(context: Context): PlantRepository {
        val database = PlantDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.plantDao())
        val appExecutors = AppExecutors()

        return PlantRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}
