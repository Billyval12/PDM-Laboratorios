package com.example.laboratorio05pdm.ui.movie.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratorio05pdm.R
import com.example.laboratorio05pdm.data.model.MovieModel
import com.example.laboratorio05pdm.databinding.FragmentFirstBinding
import com.example.laboratorio05pdm.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.example.laboratorio05pdm.ui.movie.viewmodel.MovieViewModel

class firstFragment : Fragment() {

    private val moviewViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentFirstBinding
    private lateinit var adapter: MovieRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.addMovieButton.setOnClickListener {
            moviewViewModel.clearData()
            it.findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }

    }

    private fun displayMovies() {
        adapter.setData(moviewViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.RecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = MovieRecyclerViewAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)
        }

        binding.RecyclerView.adapter = adapter
        displayMovies()
    }


    private fun showSelectedItem(movie:MovieModel) {
        moviewViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
    }
}