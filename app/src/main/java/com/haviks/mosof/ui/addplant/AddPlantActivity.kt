package com.haviks.mosof.ui.addplant

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.haviks.mosof.MainActivity
import com.haviks.mosof.databinding.ActivityAddPlantBinding
import com.haviks.mosof.prefs.WelcomePreference
import com.haviks.mosof.prefs.entitiy.WelcomeEntity
import com.haviks.mosof.ui.ViewModelFactory

class AddPlantActivity : AppCompatActivity() {

    private lateinit var _activityAddBinding: ActivityAddPlantBinding

    private lateinit var welcomeEntity: WelcomeEntity
    private lateinit var welcomePreference: WelcomePreference
    private lateinit var viewModel: AddPlantViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityAddBinding = ActivityAddPlantBinding.inflate(layoutInflater)
        setContentView(_activityAddBinding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel =
            ViewModelProvider(this, factory)[AddPlantViewModel::class.java]

        setPrefs()
    }

    private fun setPrefs() {
        welcomePreference = WelcomePreference(this)
        welcomeEntity = welcomePreference.getLaunchApp()

        if (welcomeEntity.isActive == true) {
            startActivity(Intent(this@AddPlantActivity, MainActivity::class.java))
        } else {
            with(_activityAddBinding) {
                this.btnNext.setOnClickListener {
                    val plantName = this.queryText.text.toString()

                    Thread{
                        viewModel.getNamePlant(plantName)
                    }.start()

                    welcomeEntity.isActive = true
                    welcomePreference.setLaunchApp(welcomeEntity)
                    startActivity(Intent(this@AddPlantActivity, MainActivity::class.java))
                }
            }
        }
    }


}