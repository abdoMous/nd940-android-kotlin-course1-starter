package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.viewmodules.MainViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding

class ShoeListingFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : FragmentShoeListingBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)

        binding.mainViewModel = mainViewModel

        binding.lifecycleOwner = this

        mainViewModel.listFormatted.observe(viewLifecycleOwner, Observer { list ->
            list.forEach {
                val textView = TextView(context)
                textView.text = it
                binding.list.addView(textView)
            }
        })
        mainViewModel.navigateToShoeDetailScreen.observe(viewLifecycleOwner, Observer {
            if(it){
                findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
                mainViewModel.doneNavigateToShoeDetailScreen()
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shoe_list_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout -> logout()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun logout() {
        findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToLoginFragment())
    }

    override fun onResume() {
        super.onResume()
        activity?.title = getString(R.string.list_shoes_screen)
    }

}