package com.example.courseselection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast

class MainCourseSelection : AppCompatActivity() {
    private var courseOneSelected: String = ""
    private var courseTwoSelected: String = ""
    private var courseThreeSelected: String = ""
    private var courseFourSelected: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_course_selection)

        val checkIOS = findViewById<CheckBox>(R.id.checkIOS)
        val checkAndroid = findViewById<CheckBox>(R.id.checkAndroid)
        val checkIOS2 = findViewById<CheckBox>(R.id.checkIOS2)
        val checkCapstone = findViewById<CheckBox>(R.id.checkCapstone)

        val radioIOSTimeOne = findViewById<RadioButton>(R.id.radioIOSTimeOne)
        val radioIOSTimeTwo = findViewById<RadioButton>(R.id.radioIOSTimeTwo)
        val radioAndroidOne = findViewById<RadioButton>(R.id.radioAndroidTimeOne)
        val radioAndroidTwo = findViewById<RadioButton>(R.id.radioAndroidTimeTwo)
        val radioIOS2One = findViewById<RadioButton>(R.id.radioIOS2TimeOne)
        val radioIOS2Two = findViewById<RadioButton>(R.id.radioIOS2TimeTwo)
        val radioCapstoneOne = findViewById<RadioButton>(R.id.radioCapstoneTimeOne)
        val radioCapstoneTwo = findViewById<RadioButton>(R.id.radioCapstoneTimeTwo)

        val buttonGoToSummary = findViewById<Button>(R.id.buttonGoToSummary)

        var aboutMe = intent.getStringExtra("aboutMe")
        var summary = ""

        checkIOS.setOnCheckedChangeListener {_, isChecked ->
            radioIOSTimeOne.isClickable = isChecked
            radioIOSTimeTwo.isClickable = isChecked

            radioIOSTimeOne.setOnClickListener {
                radioAndroidOne.isClickable = true
                radioCapstoneOne.isClickable = false
                courseOneSelected = "${getString(R.string.checkIOS)}\n${getString(R.string.radioIOSTimeOne)}\n\n"
            }
            radioIOSTimeTwo.setOnClickListener {
                radioAndroidOne.isClickable = false
                radioCapstoneOne.isClickable = true
                courseOneSelected = "${getString(R.string.checkIOS)}\n${getString(R.string.radioIOSTimeTwo)}\n\n"
            }

            if (!isChecked) {
                radioAndroidOne.isClickable = true
                radioCapstoneOne.isClickable = true

                radioIOSTimeOne.isChecked = false
                radioIOSTimeTwo.isChecked = false

                radioIOSTimeOne.isClickable = false
                radioIOSTimeTwo.isClickable = false

                courseOneSelected = ""
            }
        }

        checkAndroid.setOnCheckedChangeListener { _, isChecked ->
            radioAndroidOne.isClickable = isChecked
            radioAndroidTwo.isClickable = isChecked

            radioAndroidOne.setOnClickListener {
                radioIOSTimeTwo.isClickable = false
                courseTwoSelected = "${getString(R.string.checkAndroid)}\n${getString(R.string.radioAndroidTimeOne)}\n\n"
            }
            radioAndroidTwo.setOnClickListener {
                radioIOSTimeTwo.isClickable = true
                courseTwoSelected = "${getString(R.string.checkAndroid)}\n${getString(R.string.radioAndroidTimeTwo)}\n\n"
            }

            if (!isChecked) {
                radioIOSTimeTwo.isClickable = true

                radioAndroidOne.isChecked = false
                radioAndroidTwo.isChecked = false

                radioAndroidOne.isClickable = false
                radioAndroidTwo.isClickable = false

                courseTwoSelected = ""
            }
        }

        checkIOS2.setOnCheckedChangeListener { _, isChecked ->
            radioIOS2One.isClickable = isChecked
            radioIOS2Two.isClickable = isChecked

            radioIOS2One.setOnClickListener {
                radioCapstoneTwo.isClickable = true
                courseThreeSelected = "${getString(R.string.checkIOS2)}\n${getString(R.string.radioIOS2TimeOne)}\n\n"
            }
            radioIOS2Two.setOnClickListener {
                radioCapstoneTwo.isClickable = false
                courseThreeSelected = "${getString(R.string.checkIOS2)}\n${getString(R.string.radioIOS2TimeTwo)}\n\n"
            }

            if (!isChecked) {
                radioCapstoneTwo.isClickable = true

                radioIOS2One.isChecked = false
                radioIOS2Two.isChecked = false

                radioIOS2One.isClickable = false
                radioIOS2Two.isClickable = false

                courseThreeSelected = ""
            }
        }

        checkCapstone.setOnCheckedChangeListener { _, isChecked ->
            radioCapstoneOne.isClickable = isChecked
            radioCapstoneTwo.isClickable = isChecked

            radioCapstoneOne.setOnClickListener {
                radioIOSTimeOne.isClickable = false
                radioIOS2Two.isClickable = true
                courseFourSelected = "${getString(R.string.checkCapstone)}\n${getString(R.string.radioCapstoneTimeOne)}\n\n"
            }
            radioCapstoneTwo.setOnClickListener {
                radioIOSTimeOne.isClickable = true
                radioIOS2Two.isClickable = false
                courseFourSelected = "${getString(R.string.checkCapstone)}\n${getString(R.string.radioCapstoneTimeTwo)}\n\n"
            }

            if (!isChecked) {
                radioIOSTimeOne.isClickable = true
                radioIOS2Two.isClickable = true

                radioCapstoneOne.isChecked = false
                radioCapstoneTwo.isChecked = false

                radioCapstoneOne.isClickable = false
                radioCapstoneTwo.isClickable = false

                courseFourSelected = ""
            }
        }

        buttonGoToSummary.setOnClickListener {
            summary += aboutMe + ", $courseOneSelected, $courseTwoSelected, " +
                                 "$courseThreeSelected, $courseFourSelected"
            val intent = Intent(this, MainSummary::class.java)
            intent.putExtra("aboutMe", aboutMe)
            intent.putExtra("summary", summary)
            startActivity(intent)
        }
    }
}