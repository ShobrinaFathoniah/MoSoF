package com.haviks.mosof.data

import androidx.lifecycle.LiveData
import com.haviks.mosof.data.local.entity.PlantConditionEntity
import com.haviks.mosof.data.local.entity.PlantEntity
import com.haviks.mosof.data.local.entity.PlantNameEntity
import com.haviks.mosof.utilis.Resource

interface PlantDataSource {
    fun getPlantCondition(): LiveData<Resource<PlantConditionEntity>>
    fun insertPlantName(name: String)
    fun getPlant(): LiveData<PlantEntity>
}
