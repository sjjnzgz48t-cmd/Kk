package com.kk.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kk.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: здесь будет реализован основной интерфейс приложения
    }
}
