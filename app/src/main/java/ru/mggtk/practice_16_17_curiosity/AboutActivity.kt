package ru.mggtk.practice_16_17_curiosity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        setTitle("О программе")
    }

    fun BtnClickFinish(view: View) {
        finish()
    }
}