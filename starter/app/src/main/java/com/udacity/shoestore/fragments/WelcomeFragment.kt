package com.udacity.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.viewmodules.WelcomeViewModel
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var viewModel: WelcomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding : FragmentWelcomeBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
        binding.welcomeViewModel = viewModel
        viewModel.navigateToInstructionScreen.observe(viewLifecycleOwner, Observer {
            if(it){
                findNavController().navigate(
                        WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
                viewModel.doneNavigationToInstructionScreen()
            }

        })

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        activity?.title = getString(R.string.welcome_title)
    }

}