package com.android.example.fragmentresult

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.android.example.fragmentresult.databinding.FragmentInputBinding

class InputFragment : Fragment() {
    private lateinit var binding: FragmentInputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInputBinding.inflate(inflater, container, false)
        binding.finishButton.setOnClickListener {
            setFragmentResult("request_key", bundleOf(
                "result_key" to binding.editText.text.toString()
            ))
            parentFragmentManager.popBackStack()
        }
        return binding.root
    }
}