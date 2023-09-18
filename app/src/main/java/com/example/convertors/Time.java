package com.example.convertors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class Time extends AppCompatActivity {

    LottieAnimationView animation;

    EditText time;
    Spinner spinner,spinner1;
    Button btn;
    ArrayList<String> arr = new ArrayList<>();
    ArrayList<String> arr1 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        // set animation
        animation = findViewById(R.id.animation);
        animation.setAnimation(R.raw.time);
        animation.playAnimation();

        time = findViewById(R.id.time);
        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        btn = findViewById(R.id.btn);



        // adding elements in array
        arr.add("Hour");
        arr.add("Minute");
        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arr);
        spinner.setAdapter(adp);


        // adding elements in array
        arr1.add("Minute");
        arr1.add("Second");
        ArrayAdapter<String> adp1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arr1);
        spinner1.setAdapter(adp1);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try{

                    Double tot;
                    Double amount = Double.parseDouble(time.getText().toString());
                    if (spinner.getSelectedItem().toString() == "Hour" && spinner1.getSelectedItem().toString() == "Minute"){
                        tot = amount * 60;
                        Toast.makeText(Time.this, "TIme in Minutes: "+tot+" min", Toast.LENGTH_SHORT).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "Minute"  && spinner1.getSelectedItem().toString() == "Second"){
                        tot = amount * 60;
                        Toast.makeText(Time.this, "TIme in Seconds: "+tot+" sec", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Time.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    }

                }catch (NumberFormatException e){
                    Toast.makeText(Time.this, "Please enter valid Time.", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}