package com.myratorjyev.sqlite.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.myratorjyev.sqlite.MainViewModel
import com.myratorjyev.sqlite.R
import com.myratorjyev.sqlite.databinding.FragmentReadBinding

class ReadFragment : Fragment() {

    private lateinit var binding: FragmentReadBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReadBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val listOfData = viewModel.readData()
        for (item in listOfData) {
            binding.tvSave.append("${item.id} - ${item.title} - ${item.content}")
            binding.tvSave.append("\n")
        }
    }

}