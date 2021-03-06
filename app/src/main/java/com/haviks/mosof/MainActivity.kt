package com.haviks.mosof

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.haviks.mosof.databinding.ActivityMainBinding
import com.haviks.mosof.ui.action.FertilizingPlantFragment
import com.haviks.mosof.ui.action.WateringPlantFragment
import com.haviks.mosof.ui.plantcondition.PlantConditionFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMenu.toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.appBarMenu.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_content_menu, PlantConditionFragment())
                .commit()
            supportActionBar?.title = getString(R.string.app_name)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        var title = getString(R.string.app_name)
        when (item.itemId) {
            R.id.nav_home -> {
                fragment = PlantConditionFragment()
                title = getString(R.string.app_name)
            }
            R.id.nav_add_fertilizer -> {
                fragment = FertilizingPlantFragment()
                title = getString(R.string.app_name)
            }
            R.id.nav_add_water -> {
                fragment = WateringPlantFragment()
                title = getString(R.string.app_name)
            }
        }

        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_content_menu, fragment)
                .commit()
        }

        supportActionBar?.title = title

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private var exit = false
    override fun onBackPressed() {
        if (exit) {
            finishAffinity()
        } else {
            Toast.makeText(
                this, getString(R.string.exit_verif),
                Toast.LENGTH_SHORT
            ).show()
            exit = true
            Handler(Looper.getMainLooper()).postDelayed({ exit = false }, 3 * 1000)
        }
    }
}