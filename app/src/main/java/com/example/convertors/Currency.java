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

public class Currency extends AppCompatActivity {

    LottieAnimationView animation;

    EditText time;
    Spinner spinner,spinner1;
    Button btn;
    ArrayList<String> arr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        // set animation
        animation = findViewById(R.id.animation);
        animation.setAnimation(R.raw.currency);
        animation.playAnimation();

        time = findViewById(R.id.time);
        spinner = findViewById(R.id.spinner);
        btn = findViewById(R.id.btn);


        // adding elements in array
        arr.add("Dollar");
        arr.add("Euro");
        arr.add("Indian Rupee");
        arr.add("Saudi Riyal");
        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arr);
        spinner.setAdapter(adp);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try{

                    Double tot;
                    Double amount = Double.parseDouble(time.getText().toString());
                    if (spinner.getSelectedItem().toString() == "Dollar"){
                        tot = amount * 0.0034;
                        Toast.makeText(Currency.this, "Amount in USD: "+tot+" USD", Toast.LENGTH_SHORT).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "Euro" ){
                        tot = amount * 0.0032;
                        Toast.makeText(Currency.this, "Amount in EURO: "+tot+" EUR", Toast.LENGTH_SHORT).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "Indian Rupee"){
                        tot = amount * 0.28;
                        Toast.makeText(Currency.this, "Amount in INR: "+tot+" INR", Toast.LENGTH_SHORT).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "Saudi Riyal"){
                        tot = amount * 0.013;
                        Toast.makeText(Currency.this, "Amount in SAR: "+tot+" SAR", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Currency.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    }

                }catch (NumberFormatException e){
                    Toast.makeText(Currency.this, "Please enter valid Currency.", Toast.LENGTH_SHORT).show();
                }


            }
        });




    }
}