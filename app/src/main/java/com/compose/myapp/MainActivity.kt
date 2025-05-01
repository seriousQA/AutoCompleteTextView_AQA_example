package com.compose.myapp

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var autoCompleteTextView: AutoCompleteTextView
    private lateinit var button: Button
    private lateinit var languages: List<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        autoCompleteTextView = findViewById(R.id.autoTextView)
        button = findViewById(R.id.button)

        languages = listOf("Java", "Kotlin", "CSharp", "Swift", "Python", "C++", "Perl", "Javascript", "C")
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, languages)
        autoCompleteTextView.setAdapter(adapter)
        autoCompleteTextView.setOnItemClickListener(OnItemClickListener { arg0, arg1, arg2, arg3 ->
            val `in` = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            `in`.hideSoftInputFromWindow(arg1.applicationWindowToken, 0)
        })

        button.setOnClickListener {
            val enteredText = "Submitted language:" + " " + autoCompleteTextView.text
            Toast.makeText(this, enteredText, Toast.LENGTH_SHORT).show()
        }
    }
}
