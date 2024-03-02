package com.leon.anmp_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import com.leon.anmp_week1.databinding.FragmentMainBinding
import kotlin.random.Random

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private var rndNum1: Int = 0
    private var rndNum2: Int = 0
    private var ans: Int = 0
    private var score: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        generateNewQuestion()

        binding.btnSubmit.setOnClickListener {
            val input = binding.txtAnswer.text.toString().toIntOrNull()
            if (input != null && input == ans){
                score++
                generateNewQuestion()
            } else {
                val action = MainFragmentDirections.actionGameFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    private fun generateNewQuestion() {
        rndNum1 = Random.nextInt(0, 100)
        rndNum2 = Random.nextInt(0, 100)
        ans = rndNum1 + rndNum2

        binding.numX.text = rndNum1.toString()
        binding.numY.text = rndNum2.toString()
        binding.txtAnswer.text = null
    }
}