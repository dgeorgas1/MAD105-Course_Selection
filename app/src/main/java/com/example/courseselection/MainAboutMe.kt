package com.example.courseselection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Switch
import android.widget.Toast

class MainAboutMe : AppCompatActivity() {
    private var monthSelected: String = ""
    private  var degreePath: String = ""
    private var chosenStudy: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_about_me)

        val monthSpinnerOptions = listOf("Jan", "Feb", "Mar", "Apr", "May", "Jun",
                                    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")

        val monthSpinner = findViewById<Spinner>(R.id.spinnerMonth)
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, monthSpinnerOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1)
        monthSpinner.adapter = adapter

        val certSpinnerOptions = listOf("Android Certificate", "IOS Certificate")

        val certSpinner = findViewById<Spinner>(R.id.spinnerCert)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, certSpinnerOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1)
        certSpinner.adapter = adapter

        val degreeSpinnerOptions = listOf("Digital Media", "Mobile Application Development", "Web Development")

        val degreeSpinner = findViewById<Spinner>(R.id.spinnerDegree)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, degreeSpinnerOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1)
        degreeSpinner.adapter = adapter

        val switch = findViewById<Switch>(R.id.switchPath)
        certSpinner.visibility = View.GONE

        switch.setOnCheckedChangeListener(){buttonView, isChecked ->
            if(isChecked){
                certSpinner.visibility = View.GONE
                degreeSpinner.visibility = View.VISIBLE
                degreePath = getString(R.string.labelDegree)
            }
            else{
                degreeSpinner.visibility = View.GONE
                certSpinner.visibility = View.VISIBLE
                degreePath = getString(R.string.labelCert)
            }
        }
        val entryFName = findViewById<EditText>(R.id.editFName)
        val entryLName = findViewById<EditText>(R.id.editLName)
        val entryPhone = findViewById<EditText>(R.id.editPhone)
        val entryDate = findViewById<EditText>(R.id.editDate)
        val entryYear = findViewById<EditText>(R.id.editYear)

        val buttonNext = findViewById<Button>(R.id.buttonNext)
        entryFName.requestFocus()

        monthSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                monthSelected = monthSpinner.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        degreeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                chosenStudy = degreeSpinner.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        certSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                chosenStudy = certSpinner.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        buttonNext.setOnClickListener {
            if (entryFName.text.toString() == ""){
                Toast.makeText(this, "Please Enter A First Name", Toast.LENGTH_SHORT).show()
            }
            else if (entryLName.text.toString() == ""){
                entryLName.requestFocus()
                Toast.makeText(this, "Please Enter A Last Name", Toast.LENGTH_SHORT).show()
            }
            else if (entryPhone.text.toString() == ""){
                entryPhone.requestFocus()
                Toast.makeText(this, "Please Enter A Phone Number", Toast.LENGTH_SHORT).show()
            }
            else if (entryDate.text.toString() == ""){
                entryDate.requestFocus()
                Toast.makeText(this, "Please Enter A Birth Date", Toast.LENGTH_SHORT).show()
            }
            else if (entryYear.text.toString() == ""){
                entryYear.requestFocus()
                Toast.makeText(this, "Please Enter A Birth Year", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainAboutMe, MainCourseSelection::class.java)
                val aboutMe = "${entryFName.text}, ${entryLName.text}, ${entryPhone.text}, " +
                        "$monthSelected, ${entryDate.text}, ${entryYear.text}, " +
                        "$degreePath, $chosenStudy"
                intent.putExtra("aboutMe", aboutMe)
                startActivity(intent)
            }
        }
    }
}