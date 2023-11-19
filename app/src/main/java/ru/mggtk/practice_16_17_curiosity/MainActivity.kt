package ru.mggtk.practice_16_17_curiosity

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Practika16-17")
        val themeSwitchButton:Button = findViewById(R.id.button)
        themeSwitchButton.setOnClickListener {
            toggleTheme()
        }
    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        invalidateOptionsMenu()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        val menuItemLight = menu?.findItem(R.id.setthem_light_menu_item)
        if (menuItemLight != null) {
            menuItemLight.setIcon(getAppropriateIconNight())
        }
        val menuItemDark = menu?.findItem(R.id.setthem_dark_menu_item)
        if (menuItemDark != null) {
            menuItemDark.setIcon(getAppropriateIconLight())
        }
        return true
    }
    private fun getAppropriateIconLight(): Int {
        return if (isDarkTheme()) {
            R.drawable.baseline_wb_sunny_24
        } else {
            R.drawable.baseline_wb_sunny_24_light
        }
    }
    private fun getAppropriateIconNight(): Int {
        return if (isDarkTheme()) {
            R.drawable.baseline_bedtime_24
        } else {
            R.drawable.baseline_bedtime_24_light
        }
    }
    private fun isDarkTheme(): Boolean {
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return currentNightMode == Configuration.UI_MODE_NIGHT_YES
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        when(item.itemId){
            R.id.setthem_light_menu_item -> toggleTheme_light()
            R.id.setthem_dark_menu_item ->  toggleTheme_dark()
            R.id.about_menu_item -> about_menu_open()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun about_menu_open() {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }
    fun toggleTheme_light(){
        val currentNightMode = resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK
        if (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_NO) {
            // Светлая тема, переключаем на темную
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            recreate()
        }
    }
    fun toggleTheme_dark(){
        val currentNightMode = resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK
        if (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
            // Темная тема, переключаем на светлую
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            recreate()
        }
    }
        fun toggleTheme() {
        val currentNightMode = resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK
        if (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_NO) {
            // Светлая тема, переключаем на темную
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            // Темная тема, переключаем на светлую
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        recreate() // Пересоздаем активность
    }

}