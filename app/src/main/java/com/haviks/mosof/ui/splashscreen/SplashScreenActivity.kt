package com.haviks.mosof.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.haviks.mosof.R
import com.haviks.mosof.ui.addplant.AddPlantActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(mainLooper).postDelayed({
            val intent = Intent(this, AddPlantActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}