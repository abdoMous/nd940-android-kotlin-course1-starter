package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.viewmodules.MainViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentShoeDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        binding.mainViewModel = mainViewModel

        mainViewModel.eventCancel.observe(viewLifecycleOwner, Observer { hasCanceled ->
            if (hasCanceled) {
                findNavController ().navigate(
                        ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment())
                mainViewModel.doneCanceling()
            }
        })

        mainViewModel.eventSaveShoe.observe(viewLifecycleOwner, Observer { hasSaved ->

            if(hasSaved!!){
                findNavController().navigate(
                        ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment())
                mainViewModel.doneSaving()
            }
        })

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        activity?.title = getString(R.string.add_shoe)
    }
}