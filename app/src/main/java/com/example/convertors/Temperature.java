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

public class Temperature extends AppCompatActivity {
    LottieAnimationView animation;

    EditText temp;
    Spinner spinner;
    Button btn;
    ArrayList<String> arr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);


        // set animation
        animation = findViewById(R.id.animation);
        animation.setAnimation(R.raw.temperature);
        animation.playAnimation();


        temp = findViewById(R.id.temp);
        spinner = findViewById(R.id.spinner);
        btn = findViewById(R.id.btn);

        arr.add("Celsius");
        arr.add("Kelvin");
        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arr);
        spinner.setAdapter(adp);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try{

                    Double tot;
                    Double amount = Double.parseDouble(temp.getText().toString());
                    if (spinner.getSelectedItem().toString() == "Celsius"){
                        tot = (amount - 32) * 5/9 ;
                        Toast.makeText(Temperature.this, "Temp in Celsius is: "+tot+" 'C", Toast.LENGTH_LONG).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "Kelvin"){
                        tot = (amount - 32) * 5/9  + 273.15;
                        Toast.makeText(Temperature.this, "Temp in Kelvin is: "+tot+" 'K", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(Temperature.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    }

                }catch (NumberFormatException e){
                    Toast.makeText(Temperature.this, "Please enter valid Temperature.", Toast.LENGTH_SHORT).show();
                }


            }
        });



    }
}