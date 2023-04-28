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
import com.google.android.material.textfield.TextInputEditText


class CreateMovieFragment : Fragment() {

    private val viewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    lateinit var name: TextInputEditText
    lateinit var category: TextInputEditText
    lateinit var description: TextInputEditText
    lateinit var calification: TextInputEditText
    lateinit var actionSubmit: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind(view)
        actionSubmit.setOnClickListener {
            createMovie()
        }
    }

    private fun bind(view: View){
        name = view?.findViewById(R.id.name_value)!!
        category = view?.findViewById(R.id.name_value2)!!
        description = view?.findViewById(R.id.description_value)!!
        calification = view?.findViewById(R.id.calification_value)!!
        actionSubmit = view?.findViewById(R.id.submit_button)!!
    }

    private fun createMovie(){
        val newMovie = MovieModel(
            name.text.toString(),
            category.text.toString(),
            description.text.toString(),
            calification.text.toString()

        )
        viewModel.addMovie(newMovie)

        Log.d("APP TAG", viewModel.getMovies().toString())

        findNavController().popBackStack()
    }


}