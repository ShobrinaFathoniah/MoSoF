package com.haviks.mosof.ui.action

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.haviks.mosof.R
import com.haviks.mosof.databinding.FragmentFertilizingPlantBinding
import com.haviks.mosof.ui.ViewModelFactory

class FertilizingPlantFragment : Fragment() {
    private var _fragmentFertilizingBinding: FragmentFertilizingPlantBinding? = null
    private val _binding get() = _fragmentFertilizingBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _fragmentFertilizingBinding =
            FragmentFertilizingPlantBinding.inflate(inflater, container, false)

        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel =
            ViewModelProvider(this, factory)[FertilizingPlantViewModel::class.java]


        _fragmentFertilizingBinding?.btnFertilizing?.setOnClickListener {
            Toast.makeText(context, getString(R.string.on), Toast.LENGTH_SHORT).show()
        }

        _fragmentFertilizingBinding?.btnFertilizing2?.setOnClickListener {
            Toast.makeText(context, getString(R.string.off), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentFertilizingBinding = null
    }
}