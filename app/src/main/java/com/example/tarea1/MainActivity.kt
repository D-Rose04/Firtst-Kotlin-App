package com.example.tarea1

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tabs)
        viewPager = findViewById(R.id.viewPager)

        viewPager.adapter = ContentAdapter(this)
        TabLayoutMediator(tabLayout,viewPager){ tab, index ->
            tab.text = when(index){
                0 -> {"Calculator"}
                1 -> {"Info"}
                else -> {throw Resources.NotFoundException("404")}
            }
        }.attach()

    }
}