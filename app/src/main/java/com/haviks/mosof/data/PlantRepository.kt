package com.haviks.mosof.data

import androidx.lifecycle.LiveData
import com.haviks.mosof.data.local.LocalDataSource
import com.haviks.mosof.data.local.entity.PlantEntity
import com.haviks.mosof.data.remote.RemoteDataSource
import com.haviks.mosof.data.remote.network.ApiResponse
import com.haviks.mosof.data.remote.response.PlantResponse
import com.haviks.mosof.utilis.AppExecutors
import com.haviks.mosof.utilis.Resource

class PlantRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : PlantDataSource {
    companion object {

        @Volatile
        private var instance: PlantRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): PlantRepository =
            instance ?: synchronized(this) {
                instance
                    ?: PlantRepository(remoteData, localData, appExecutors).apply {
                        instance = this
                    }
            }
    }

    override fun getPlantCondition(): LiveData<Resource<PlantEntity>> {
        return object :
            NetworkBoundResource<PlantEntity, PlantResponse>(
                appExecutors
            ) {
            override fun loadFromDB(): LiveData<PlantEntity> =
                localDataSource.getAllPlantCondition()

            override fun shouldFetch(data: PlantEntity?): Boolean {

                return true
            }

            override fun createCall(): LiveData<ApiResponse<PlantResponse>> =
                remoteDataSource.getPlantCondition()

            override fun saveCallResult(data: PlantResponse) {
                val plantData =
                    PlantEntity(
                        1,
                        "",
                        data.humidity.toString(),
                        data.temperature.toString(),
                        data.pH.toString()
                    )
                localDataSource.insertPlant(plantData)
            }
        }.asLiveData()
    }
}