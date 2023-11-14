package com.example.courseselection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Constants
        val inputUsername = findViewById<EditText>(R.id.inputUsername)
        val inputPassword = findViewById<EditText>(R.id.inputPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        val correctUsername = getString(R.string.correctUsername)
        val correctPassword = getString(R.string.correctPassword)

        //Variables
        var result = ""
        var toast: String

        //Set Cursor To Enter Username Field Upon Launch
        inputUsername.requestFocus()

        buttonLogin.setOnClickListener {
            result = checkLoginCredentials(inputUsername.text.toString(), inputPassword.text.toString(),
                                correctUsername, correctPassword)

            when (result) {
                "Success" -> {
                    toast = getString(R.string.loginSuccess)

                    val intent = Intent(this, MainClassList::class.java)
                    startActivity(intent)

//                    inputUsername.requestFocus()
//                    inputUsername.setText("")
//                    inputPassword.setText("")
                }
                "Wrong Password" -> {
                    //Print Wrong Password, Move Cursor To Password Field and Erase Input
                    toast = getString(R.string.wrongPassword)

                    inputPassword.requestFocus()
                    inputPassword.setText("")
                }
                else -> {
                    //Print Wrong Username and Erase Input
                    toast = getString(R.string.wrongUsername)

                    inputUsername.setText("")
                }
            }
            Toast.makeText(this, toast, Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkLoginCredentials(inputUsername: String, inputPassword: String,
                   correctUsername: String, correctPassword: String): String{
        val result: String

        if (inputUsername == correctUsername){
            if (inputPassword == correctPassword){
                result = "Success"
            }
            else{
                result = "Wrong Password"
            }
        }
        else{
            result = "Wrong Username"
        }
        return result
    }
}