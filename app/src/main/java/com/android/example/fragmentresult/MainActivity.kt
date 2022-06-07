package com.android.example.fragmentresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.example.fragmentresult.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().apply {
            addToBackStack(null)
            replace(R.id.container, MainFragment())
            commit()
        }
    }
}