package com.haviks.mosof.ui.plantcondition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.haviks.mosof.databinding.FragmentPlantConditionBinding
import com.haviks.mosof.ui.ViewModelFactory

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentConditionBinding = null
    }
}