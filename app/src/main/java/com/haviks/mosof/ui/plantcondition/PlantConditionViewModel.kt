package com.haviks.mosof.ui.plantcondition

import androidx.lifecycle.ViewModel
import com.haviks.mosof.data.PlantRepository

class PlantConditionViewModel(private val _repository: PlantRepository) : ViewModel() {
    val humidity = _repository.getHumidity()
    val temperature = _repository.getTemperature()
    val soilMoisture = _repository.getSoilMoisture()
    val soilDryness = _repository.getSoilDryness()
    val getAll = _repository.getPlant()
}