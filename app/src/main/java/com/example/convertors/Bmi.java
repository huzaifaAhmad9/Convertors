package com.example.convertors;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class Bmi extends AppCompatActivity {
    LottieAnimationView animation;
    private EditText weightEditText, heightEditText;
    private TextView bmiResultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        // set animation
        animation = findViewById(R.id.animation);
        animation.setAnimation(R.raw.age);
        animation.playAnimation();


        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        bmiResultTextView = findViewById(R.id.bmiResultTextView);

        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });

    }

    private void calculateBMI() {
        try {
            // Get weight and height from EditText fields
            double weight = Double.parseDouble(weightEditText.getText().toString());
            double height = Double.parseDouble(heightEditText.getText().toString());

            // Calculate BMI
            double bmi = weight / (height * height);

            // Display the result
            String resultMessage = "Your BMI is: " + String.format("%.2f", bmi);

            bmiResultTextView.setText(resultMessage);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid weight and height.", Toast.LENGTH_SHORT).show();
        }
    }
}