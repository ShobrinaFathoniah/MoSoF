package com.haviks.mosof.data

import androidx.lifecycle.LiveData
import com.haviks.mosof.data.local.entity.*
import com.haviks.mosof.utilis.Resource

interface PlantDataSource {
    fun getHumidity(): LiveData<Resource<PlantHumidityEntity>>
    fun getTemperature(): LiveData<Resource<PlantTemperatureEntity>>
    fun getSoilDryness(): LiveData<Resource<SoilDrynessEntity>>
    fun getSoilMoisture(): LiveData<Resource<SoilMoistureEntity>>
    fun insertPlantName(name: String)
    fun getPlant(): LiveData<PlantEntity>
}
