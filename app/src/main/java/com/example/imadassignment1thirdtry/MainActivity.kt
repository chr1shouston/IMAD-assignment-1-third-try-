package com.example.imadassignment1thirdtry

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    // declaring design elements as variables
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView
    private lateinit var btnReset: Button
    private lateinit var edtInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Initializing variables
        btnReset = findViewById(R.id.btnReset)
        btnCalculate = findViewById(R.id.btnCalculate)
        tvResult = findViewById(R.id.tvResult)
        edtInput = findViewById(R.id.edtInput)


        // Predefining the different sparks for each time of day
        val morningSpark = "Send a 'Good Morning' text to a family member!"
        val midmorningSpark = "Reach out to a colleague with a quick 'Thank you'!"
        val afternoonSpark = "Share a funny Meme or interesting link with a friend!"
        val afternoonSnackTimeSpark = "Send a quick 'Thinking of you' message!"
        val dinnerSpark = "Call a friend or relative for a 5-minute catch-up!"
        val nightSpark = "Leave a thoughtful comment on a friend's post"

        // Waits for user to press the button, then executes code inside
        btnCalculate.setOnClickListener {
            // if the text the user inputs matches one of the desired times of day, then output the appropriate spark
            if(edtInput.text.toString().lowercase() == "morning"){
                tvResult.text = morningSpark
            }
            else if (edtInput.text.toString().lowercase() == "mid morning" ||
                     edtInput.text.toString().lowercase() == "mid-morning"){

                tvResult.text = midmorningSpark

            }
            else if (edtInput.text.toString().lowercase() == "afternoon"){
                tvResult.text = afternoonSpark
            }
            else if (edtInput.text.toString().lowercase() == "snack time" ||
                     edtInput.text.toString().lowercase() == "afternoon snack time"){

                tvResult.text = afternoonSnackTimeSpark

            }
            else if (edtInput.text.toString().lowercase() == "dinner"){
                tvResult.text = dinnerSpark
            }
            else if (edtInput.text.toString().lowercase() == "night" || edtInput.text.toString().lowercase() == "after dinner"){
                tvResult.text = nightSpark
            }


            // constructive feedback if the user does not input a valid time of day
            else {
                tvResult.text = "Please enter one of the following: Morning, Mid-Morning, Afternoon, Afternoon Snack Time, Dinner, Night"
            }

        }

        btnReset.setOnClickListener { tvResult.text = "" }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}