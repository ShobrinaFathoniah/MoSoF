package com.haviks.mosof.ui.addplant

import androidx.lifecycle.ViewModel
import com.haviks.mosof.data.PlantRepository

class AddPlantViewModel(private val _repository: PlantRepository) : ViewModel() {
    fun getNamePlant(name: String) = _repository.insertPlantName(name)

}