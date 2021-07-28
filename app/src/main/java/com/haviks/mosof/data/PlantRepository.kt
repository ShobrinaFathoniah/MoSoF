package com.haviks.mosof.data

import androidx.lifecycle.LiveData
import com.haviks.mosof.data.local.LocalDataSource
import com.haviks.mosof.data.local.entity.PlantConditionEntity
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

    override fun getPlantCondition(): LiveData<Resource<PlantConditionEntity>> {
        return object :
            NetworkBoundResource<PlantConditionEntity, PlantResponse>(
                appExecutors
            ) {
            override fun loadFromDB(): LiveData<PlantConditionEntity> =
                localDataSource.getAllPlantCondition()

            override fun shouldFetch(data: PlantConditionEntity?): Boolean = true

            override fun createCall(): LiveData<ApiResponse<PlantResponse>> =
                remoteDataSource.getPlantConditions()

            override fun saveCallResult(data: PlantResponse) {
                val plantData =
                    PlantConditionEntity(
                        1,
                        data.humidity.toString(),
                        data.temperature.toString(),
                        data.pH.toString()
                    )
                localDataSource.insertPlantCondition(plantData)
            }
        }.asLiveData()
    }

    override fun insertPlantName(name: String) = localDataSource.insertPlantName(name)

    override fun getPlant(): LiveData<PlantEntity> = localDataSource.getAllPlant()
}