package com.example.laboratorio_05.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio_05.R
import com.example.laboratorio_05.data.model.MovieModel
import com.example.laboratorio_05.databinding.FragmentCreateMovieBinding
import com.google.android.material.textfield.TextInputEditText


class CreateMovieFragment : Fragment() {

    private val viewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentCreateMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCreateMovieBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }


    private fun setViewModel(){
        binding.viewmodel = viewModel
    }

    private fun observeStatus(){
        viewModel.status.observe(viewLifecycleOwner){
            status ->
            when{
                status.equals(MovieViewModel.WRONG_INFORMATION)->{
                    Log.d(APP_TAG,status)
                    viewModel.clearStatus()
                }
                status.equals(MovieViewModel.MOVIE_CREATED)->{
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, viewModel.getMovies().toString())

                    viewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    companion object{
        const val APP_TAG = "APP TAG"
    }

}