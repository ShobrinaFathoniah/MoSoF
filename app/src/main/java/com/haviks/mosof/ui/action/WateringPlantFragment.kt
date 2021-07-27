package com.haviks.mosof.ui.action

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.haviks.mosof.databinding.FragmentWateringPlantBinding
import com.haviks.mosof.ui.ViewModelFactory

class WateringPlantFragment : Fragment() {
    private var _fragmentWateringBinding: FragmentWateringPlantBinding? = null
    private val _binding get() = _fragmentWateringBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _fragmentWateringBinding =
            FragmentWateringPlantBinding.inflate(inflater, container, false)

        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel =
            ViewModelProvider(this, factory)[WateringPlantViewModel::class.java]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentWateringBinding = null
    }
}