package com.haviks.mosof.ui.addplant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.haviks.mosof.databinding.FragmentAddPlantNameBinding
import com.haviks.mosof.ui.ViewModelFactory

class AddPlantFragment : Fragment() {
    private var _fragmentAddBinding: FragmentAddPlantNameBinding? = null
    private val _binding get() = _fragmentAddBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _fragmentAddBinding =
            FragmentAddPlantNameBinding.inflate(inflater, container, false)

        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel =
            ViewModelProvider(this, factory)[AddPlantViewModel::class.java]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentAddBinding = null
    }
}