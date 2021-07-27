package com.haviks.mosof.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.haviks.mosof.data.PlantRepository
import com.haviks.mosof.ui.action.FertilizingPlantViewModel
import com.haviks.mosof.ui.action.WateringPlantViewModel
import com.haviks.mosof.ui.addplant.AddPlantViewModel
import com.haviks.mosof.ui.plantcondition.PlantConditionViewModel

class ViewModelFactory private constructor(private val plantRepository: PlantRepository) :
    ViewModelProvider.Factory {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(
                    PlantRepository.getInstance(context)
                )
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(FertilizingPlantViewModel::class.java) -> {
                FertilizingPlantViewModel(plantRepository) as T
            }
            modelClass.isAssignableFrom(WateringPlantViewModel::class.java) -> {
                WateringPlantViewModel(plantRepository) as T
            }
            modelClass.isAssignableFrom(AddPlantViewModel::class.java) -> {
                AddPlantViewModel(plantRepository) as T
            }
            modelClass.isAssignableFrom(PlantConditionViewModel::class.java) -> {
                PlantConditionViewModel(plantRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}