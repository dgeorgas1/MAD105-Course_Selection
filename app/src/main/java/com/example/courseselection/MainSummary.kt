package com.example.courseselection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainSummary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_summary)

        val labelName = findViewById<TextView>(R.id.textName)
        val labelPhoneNum = findViewById<TextView>(R.id.textPhoneNum)
        val labelMMDDYYYY = findViewById<TextView>(R.id.textMMDDYYYY)
        val labelPlanOption = findViewById<TextView>(R.id.textPlanOption)
        val labelMajorSelected = findViewById<TextView>(R.id.textMajorSelected)
        val labelCourseSelected = findViewById<TextView>(R.id.textCourseSelected)
        val buttonSummaryReturn = findViewById<Button>(R.id.buttonReturn)

        val summary = intent.getStringExtra("summary")
        val aboutMe = intent.getStringExtra("aboutMe")
        var aboutSummary = summary?.split(",")
        var name = ""
        var phone = ""
        var birthday = ""
        var degreePath = ""
        var chosenStudy = ""
        var courseOneSelected = ""
        var courseTwoSelected = ""
        var courseThreeSelected = ""
        var courseFourSelected = ""
        var count = 0

        if (aboutSummary != null) {
            for (info in aboutSummary){
                if (count <= 1) {
                    name += info
                }
                else if (count == 2) {
                    phone += info
                }
                else if (count in 3..5) {
                    birthday += info
                }
                else if (count == 6) {
                    degreePath += info
                }
                else if (count == 7) {
                    chosenStudy += info
                }
                else if (count == 8) {
                    courseOneSelected += info
                }
                else if (count == 9) {
                    courseTwoSelected += info
                }
                else if (count == 10) {
                    courseThreeSelected += info
                }
                else {
                    courseFourSelected += info
                }
                count += 1
            }
        }
        labelName.text = name
        labelPhoneNum.text = phone
        labelMMDDYYYY.text = birthday
        labelPlanOption.text = degreePath
        labelMajorSelected.text = chosenStudy
        labelCourseSelected.text = "$courseOneSelected\n$courseTwoSelected\n" +
                                    "$courseThreeSelected\n$courseFourSelected"

        buttonSummaryReturn.setOnClickListener {
            val intent = Intent(this, MainCourseSelection::class.java)
            intent.putExtra("aboutMe", aboutMe)
            startActivity(intent)
        }
    }
}