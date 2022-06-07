package com.android.example.fragmentresult

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.android.example.fragmentresult.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setFragmentResultListener("request_key") { _, bundle ->
            val result = bundle.getString("result_key")
            binding.textView.text = result
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.nextButton.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.container, InputFragment())
                addToBackStack(null)
                commit()
            }
        }

        return binding.root
    }

}