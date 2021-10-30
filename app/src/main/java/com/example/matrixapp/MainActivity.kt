package com.example.matrixapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.matrixapp.home.FruitFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = getString(R.string.main_activity_title)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FruitFragment.newInstance())
            .commitNow()
    }
}