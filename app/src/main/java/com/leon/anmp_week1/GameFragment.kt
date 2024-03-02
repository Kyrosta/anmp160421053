package com.leon.anmp_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.leon.anmp_week1.databinding.FragmentGameBinding
import androidx.navigation.fragment.navArgs


class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private val args: GameFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            val score = GameFragmentArgs.fromBundle(requireArguments()).playerScore
            binding.txtScore.text = "Your score is : $score"
        }

        binding.btnBack.setOnClickListener {
            val action = GameFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}