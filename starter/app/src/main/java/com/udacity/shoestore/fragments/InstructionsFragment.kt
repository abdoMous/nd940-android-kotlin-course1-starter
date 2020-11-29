package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.viewmodules.InstructionsViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    private lateinit var viewModel: InstructionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentInstructionsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
        viewModel = ViewModelProvider(this).get(InstructionsViewModel::class.java)
        binding.instructionsViewModel = viewModel

        viewModel.navigateToShoeListing.observe(viewLifecycleOwner, Observer {
            if(it){
                findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListingFragment())
                viewModel.doneNavigatingToShoeListing()
            }
        })
        binding.button.setOnClickListener { findNavController()
            .navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListingFragment()) }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        activity?.title = getString(R.string.instructions)
    }
}