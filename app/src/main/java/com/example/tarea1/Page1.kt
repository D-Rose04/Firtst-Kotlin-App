package com.example.tarea1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Page1 : Fragment() {
    private lateinit var editText:EditText
    private lateinit var submitBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_page1, container, false)
        editText = view.findViewById(R.id.editGrade)
        submitBtn = view.findViewById(R.id.submitBtn)
        submitBtn.setOnClickListener { handleSubmit() }

        return view
    }

    fun handleSubmit(){
        val value = editText.text.toString().toInt()
        Toast.makeText(requireActivity(),"Your grades are: ${handleGrade(value)}",Toast.LENGTH_LONG).show()
        clean()
    }

    fun handleGrade(value: Int):Char{
        var literal: Char = 'A'

        if(value < 90) literal = 'B'
        if(value < 80) literal = 'C'
        if(value < 70) literal = 'D'
        if(value < 60) literal = 'F'

        return literal
    }

    fun clean() {
        editText.text.clear()
    }

}