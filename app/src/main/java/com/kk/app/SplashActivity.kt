package com.kk.app

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.kk.app.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val handler = Handler(Looper.getMainLooper())
    private var navigated = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        playWaveAnimation()

        binding.splashRoot.setOnClickListener { goToMain() }

        handler.postDelayed({ goToMain() }, 2500)
    }

    private fun playWaveAnimation() {
        binding.waveEmoji.pivotX = binding.waveEmoji.width * 0.7f
        binding.waveEmoji.pivotY = binding.waveEmoji.height * 0.7f

        val wave = ObjectAnimator.ofPropertyValuesHolder(
            binding.waveEmoji,
            PropertyValuesHolder.ofFloat("rotation", 0f, 14f, -8f, 14f, -4f, 10f, 0f)
        )
        wave.duration = 1600
        wave.repeatCount = ValueAnimator.INFINITE
        wave.start()
    }

    private fun goToMain() {
        if (navigated) return
        navigated = true
        startActivity(Intent(this, MainActivity::class.java))
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}
