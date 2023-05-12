package com.example.laboratorio05pdm.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.laboratorio05pdm.R
import com.example.laboratorio05pdm.databinding.FragmentSecondBinding
import com.example.laboratorio05pdm.ui.movie.viewmodel.MovieViewModel

class secondFragment : Fragment() {

    private val moviewViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    fun setViewModel() {
        binding.viewmodel = moviewViewModel
    }
}