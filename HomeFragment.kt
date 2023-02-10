package com.example.mysong.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mysong.SongViewModel
import com.example.mysong.adapter.SongAdapter
import com.example.mysong.databinding.FragmentHomeBinding

class HomeFragment : Fragment(){

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: SongViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

            //adapter wird geladen
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val songAdapter = SongAdapter()
        binding.homeRecyclerView.adapter = songAdapter

        viewModel.songs.observe(viewLifecycleOwner) {
            songAdapter.submitList(it)
        }
        binding.searchButton.setOnClickListener {
            val term = binding.searchSongText.text.toString()
            viewModel.search(term)
            binding.searchSongText.setText("")
        }
    }

}