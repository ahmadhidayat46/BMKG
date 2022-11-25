package com.example.gempaterkini.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.infogempa.R
import com.example.infogempa.databinding.FragmentGempaterkiniListBinding

class GempaterkiniListFragment : Fragment() {
    private val viewModel: GempaterkiniViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGempaterkiniListBinding.inflate(inflater)
        viewModel.getGempaterkiniList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = GempaterkiniListAdapter(GempaterkiniListener { gempaterkini ->
            viewModel.onGempaterkiniClicked(gempaterkini)
            findNavController()
                .navigate(R.id.action_gempaterkiniListFragment_to_gempaterkiniDetailFragment)
        })

        // Inflate the layout for this fragment
        return binding.root
    }
}