package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get reference to button and text
        val buttonClick = findViewById<Button>(R.id.click_button)
        val clearClick = findViewById<Button>(R.id.clear_button)
        val myTextView = findViewById<TextView>(R.id.textView)
        var timesClicked = 0

        // Set on-click listener
        buttonClick.setOnClickListener {
            timesClicked += 1
            myTextView.text = timesClicked.toString()
            Toast.makeText(this@MainActivity, "You clicked me!", Toast.LENGTH_SHORT).show()
        }

        // Set clear click listener
        clearClick.setOnClickListener {
            timesClicked = 0
            myTextView.text = "Cleared"
            Toast.makeText(this@MainActivity, "You cleared me!", Toast.LENGTH_SHORT).show()
        }
    }
}