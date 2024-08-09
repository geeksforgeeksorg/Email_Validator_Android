package com.ishaanbhela.myapplication

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var myeditText: EditText
    private lateinit var email: String
    private lateinit var validate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        myeditText = findViewById(R.id.emailField)
        email = myeditText.text.toString().trim()
        validate = findViewById(R.id.validateButton)

        // Setting onClick listener on Validate button to check if email pattern entered by user is correct or not.
        validate.setOnClickListener{
            check()
        }
    }

    private fun check() {
        // Getting the user input
        val text1 = myeditText.text

        if(text1.isEmpty()) // check if user have not entered then ask for enter
        {
            Toast.makeText(this@MainActivity,"enter your email id",Toast.LENGTH_LONG).show()
        }
        else
        {
            if (Patterns.EMAIL_ADDRESS.matcher(text1).matches()) { // using EMAIL_ADREES matcher
                Toast.makeText(this@MainActivity, "Email Verified", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this@MainActivity, "Enter valid Email address !", Toast.LENGTH_LONG).show()
            }
        }
    }
}