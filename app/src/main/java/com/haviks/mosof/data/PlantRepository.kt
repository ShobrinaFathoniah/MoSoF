package com.haviks.mosof.data

import androidx.lifecycle.LiveData
import com.haviks.mosof.data.local.LocalDataSource
import com.haviks.mosof.data.local.entity.*
import com.haviks.mosof.data.remote.RemoteDataSource
import com.haviks.mosof.data.remote.network.ApiResponse
import com.haviks.mosof.data.remote.response.*
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

    override fun getHumidity(): LiveData<Resource<PlantHumidityEntity>> {
        return object :
            NetworkBoundResource<PlantHumidityEntity, HumidityResponse>(
                appExecutors
            ) {
            override fun loadFromDB(): LiveData<PlantHumidityEntity> =
                localDataSource.getHumidity()

            override fun shouldFetch(data: PlantHumidityEntity?): Boolean = true

            override fun createCall(): LiveData<ApiResponse<HumidityResponse>> =
                remoteDataSource.getHumidity()

            override fun saveCallResult(data: HumidityResponse) {
                val plantData =
                    PlantHumidityEntity(
                        1,
                        data.lastValue.toString()
                    )
                localDataSource.insertHumidity(plantData)
            }
        }.asLiveData()
    }

    override fun getTemperature(): LiveData<Resource<PlantTemperatureEntity>> {
        return object :
            NetworkBoundResource<PlantTemperatureEntity, TemperatureResponse>(
                appExecutors
            ) {
            override fun loadFromDB(): LiveData<PlantTemperatureEntity> =
                localDataSource.getTemperature()

            override fun shouldFetch(data: PlantTemperatureEntity?): Boolean = true

            override fun createCall(): LiveData<ApiResponse<TemperatureResponse>> =
                remoteDataSource.getTemperature()

            override fun saveCallResult(data: TemperatureResponse) {
                val plantData =
                    PlantTemperatureEntity(
                        1,
                        data.lastValue.toString()
                    )
                localDataSource.insertTemperature(plantData)
            }
        }.asLiveData()
    }

    override fun getSoilDryness(): LiveData<Resource<SoilDrynessEntity>> {
        return object :
            NetworkBoundResource<SoilDrynessEntity, SoilDrynessResponse>(
                appExecutors
            ) {
            override fun loadFromDB(): LiveData<SoilDrynessEntity> =
                localDataSource.getSoilDryness()

            override fun shouldFetch(data: SoilDrynessEntity?): Boolean = true

            override fun createCall(): LiveData<ApiResponse<SoilDrynessResponse>> =
                remoteDataSource.getSoilDryness()

            override fun saveCallResult(data: SoilDrynessResponse) {
                val plantData =
                    SoilDrynessEntity(
                        1,
                        data.lastValue.toString()
                    )
                localDataSource.insertSoilDryness(plantData)
            }
        }.asLiveData()
    }

    override fun getSoilMoisture(): LiveData<Resource<SoilMoistureEntity>> {
        return object :
            NetworkBoundResource<SoilMoistureEntity, SoilMoistureResponse>(
                appExecutors
            ) {
            override fun loadFromDB(): LiveData<SoilMoistureEntity> =
                localDataSource.getSoilMoisture()

            override fun shouldFetch(data: SoilMoistureEntity?): Boolean = true

            override fun createCall(): LiveData<ApiResponse<SoilMoistureResponse>> =
                remoteDataSource.getSoilMoisture()

            override fun saveCallResult(data: SoilMoistureResponse) {
                val plantData =
                    SoilMoistureEntity(
                        1,
                        data.lastValue.toString()
                    )
                localDataSource.insertSoilMoisture(plantData)
            }
        }.asLiveData()
    }

    override fun insertPlantName(name: String) = localDataSource.insertPlantName(name)

    override fun getPlant(): LiveData<PlantEntity> = localDataSource.getAllPlant()
}