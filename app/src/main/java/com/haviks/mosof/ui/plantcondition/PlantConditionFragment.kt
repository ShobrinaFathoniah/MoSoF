package com.haviks.mosof.ui.plantcondition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.haviks.mosof.databinding.FragmentPlantConditionBinding
import com.haviks.mosof.ui.ViewModelFactory
import java.lang.StringBuilder

class PlantConditionFragment : Fragment() {
    private var _fragmentConditionBinding: FragmentPlantConditionBinding? = null
    private val _binding get() = _fragmentConditionBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _fragmentConditionBinding =
            FragmentPlantConditionBinding.inflate(inflater, container, false)

        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel =
            ViewModelProvider(this, factory)[PlantConditionViewModel::class.java]

        viewModel.humidity.observe(viewLifecycleOwner, { humidity ->
            viewModel.temperature.observe(viewLifecycleOwner, { temperature ->
                viewModel.soilDryness.observe(viewLifecycleOwner, {dryness ->
                    viewModel.soilMoisture.observe(viewLifecycleOwner, { moisture ->
                        viewModel.getAll.observe(viewLifecycleOwner, { all ->
                               val humid = humidity.data?.humidity ?: "0"
                               val temp = temperature.data?.temperature ?: "0"
                               val soilMoisture = moisture.data?.soilMoisture ?: "0"
                            val soilDryness = dryness.data?.soilDryness ?: "0"
                            val plantName = all?.name ?: "TanamanKu"

                            _fragmentConditionBinding.apply {
                                 this?.tvHumidity?.text = humid
                                 this?.tvSoilMoisture?.text = soilMoisture
                                 this?.tvTemperature?.text = StringBuilder("${temp}\u2103")
                                this?.tvSoilDryness?.text = StringBuilder("${soilDryness}%")
                                this?.tvPlantName?.text = plantName
                            }
                        })
                    })
                })
            })
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentConditionBinding = null
    }
}