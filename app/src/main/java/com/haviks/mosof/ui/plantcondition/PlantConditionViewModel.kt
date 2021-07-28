package com.haviks.mosof.ui.plantcondition

import androidx.lifecycle.ViewModel
import com.haviks.mosof.data.PlantRepository

class PlantConditionViewModel(private val _repository: PlantRepository) : ViewModel() {
    val condition = _repository.getPlantCondition()
    val getAll = _repository.getPlant()
}