package com.myratorjyev.sqlite.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.myratorjyev.sqlite.MAIN
import com.myratorjyev.sqlite.MainViewModel
import com.myratorjyev.sqlite.databinding.FragmentCreateBinding
import com.myratorjyev.sqlite.db.MyDbManager

class CreateFragment : Fragment() {

    private lateinit var binding: FragmentCreateBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.button.setOnClickListener {
            viewModel.insertDataToDb(
                binding.edTitle.text.toString(),
                binding.edContent.text.toString()
            )
            binding.edTitle.text.clear()
            binding.edContent.text.clear()
        }
    }

}