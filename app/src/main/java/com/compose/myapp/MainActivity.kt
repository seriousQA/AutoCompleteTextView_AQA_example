package com.compose.myapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.compose.compose.R


class MainActivity : AppCompatActivity() {
    private lateinit var autoCompleteTextView: AutoCompleteTextView
    private lateinit var languages: List<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        autoCompleteTextView = findViewById(R.id.autoTextView)

        languages = listOf("Java", "Kotlin", "CSharp", "Swift", "Python", "C++", "Perl", "Javascript", "C")
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, languages)
        autoCompleteTextView.setAdapter(adapter)
        autoCompleteTextView.setOnFocusChangeListener { _, _ ->
            autoCompleteTextView.showDropDown()
        }
    }
}