package com.example.laboratorio05pdm.ui.movie.newmovie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio05pdm.databinding.FragmentThirdBinding
import com.example.laboratorio05pdm.ui.movie.viewmodel.MovieViewModel

class thirdFragment : Fragment() {

    private val ViewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = ViewModel
    }

    private fun observeStatus() {
        ViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG, status)
                    ViewModel.clearStatus()
                }
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, ViewModel.getMovies().toString())

                    ViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    companion object {
        const val APP_TAG = "APP_TAG"
    }
}