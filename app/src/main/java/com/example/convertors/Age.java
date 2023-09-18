package com.example.convertors;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class Age extends AppCompatActivity {

    private DatePicker datePicker;
    private Button calculateButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);


        datePicker = findViewById(R.id.datePicker);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAge();
            }
        });

    }

    private void calculateAge() {
        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int day = datePicker.getDayOfMonth();

        Calendar dob = Calendar.getInstance();
        dob.set(year, month, day);  // setting format

        Calendar currentDate = Calendar.getInstance();

        if (dob.after(currentDate)) {
            // Display an error toast if the selected date is in the future
            Toast.makeText(this, "Please select a valid Yaer" , Toast.LENGTH_SHORT).show();
            return;
        }

        int age = currentDate.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        // this year birthday is gone or have to come
        if (currentDate.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }



        Toast.makeText(this, "Your Age is: "+age+" years", Toast.LENGTH_SHORT).show();
    }
}