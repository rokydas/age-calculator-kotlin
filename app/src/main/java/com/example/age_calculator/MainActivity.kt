package com.example.age_calculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener { view ->
            clickDatePicker(view)
        }

    }

    private fun clickDatePicker(view: View) {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                    view, selectedYear, selectedMonth, selectedDay ->
                val selectedDateStr = "$selectedDay/${selectedMonth+1}/$selectedYear"
                selectedDate.text = selectedDateStr

                val currentDateInSecond = System.currentTimeMillis() / 1000

                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = dateFormat.parse(selectedDateStr)

            },
            year,
            month,
            day).show()
    }
}