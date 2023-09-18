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

public class Weight extends AppCompatActivity {


    LottieAnimationView animation;

    EditText time;
    Spinner spinner,spinner1;
    Button btn;
    ArrayList<String> arr = new ArrayList<>();
    ArrayList<String> arr1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);




        // set animation
        animation = findViewById(R.id.animation);
        animation.setAnimation(R.raw.wieght);
        animation.playAnimation();

        time = findViewById(R.id.time);
        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        btn = findViewById(R.id.btn);



        // adding elements in array
        arr.add("KiloGram");
        arr.add("Gram");
        arr.add("Pound");
        arr.add("Ounce");
        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arr);
        spinner.setAdapter(adp);


        // adding elements in array
        arr1.add("KiloGram");
        arr1.add("Gram");
        arr1.add("Pound");
        arr1.add("Ounce");
        ArrayAdapter<String> adp1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arr1);
        spinner1.setAdapter(adp1);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try{

                    Double tot;
                    Double amount = Double.parseDouble(time.getText().toString());

                    // kilogram
                    if (spinner.getSelectedItem().toString() == "KiloGram" && spinner1.getSelectedItem().toString() == "Gram"){
                        tot = amount * 1000;
                        Toast.makeText(Weight.this, "Value in Gram: "+tot+" gm", Toast.LENGTH_SHORT).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "KiloGram"  && spinner1.getSelectedItem().toString() == "Pound"){
                        tot = amount * 2.205;
                        Toast.makeText(Weight.this, "Value in Pound: "+tot, Toast.LENGTH_SHORT).show();                    }
                    else if (spinner.getSelectedItem().toString() == "KiloGram"  && spinner1.getSelectedItem().toString() == "Ounce"){
                        tot = amount * 35.274;
                        Toast.makeText(Weight.this, "Value in Ounce: "+tot, Toast.LENGTH_SHORT).show();                    }
                    //gram
                    else if (spinner.getSelectedItem().toString() == "Gram"  &&  spinner1.getSelectedItem().toString() == "KiloGram"){
                        tot = amount / 1000;
                        Toast.makeText(Weight.this, "Value in KiloGram: "+tot+" kg", Toast.LENGTH_SHORT).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "Gram"  && spinner1.getSelectedItem().toString() == "Pound"){
                        tot = amount / 453.6;
                        Toast.makeText(Weight.this, "Value in Pound: "+tot, Toast.LENGTH_SHORT).show();                    }
                    else if (spinner.getSelectedItem().toString() == "Gram"  && spinner1.getSelectedItem().toString() == "Ounce"){
                        tot = amount / 28.35;
                        Toast.makeText(Weight.this, "Value in Ounce: "+tot, Toast.LENGTH_SHORT).show();                    }
                    // pound
                    else if (spinner.getSelectedItem().toString() == "Pound"  &&  spinner1.getSelectedItem().toString() == "KiloGram"){
                        tot = amount / 2.205;
                        Toast.makeText(Weight.this, "Value in KiloGram: "+tot+" kg", Toast.LENGTH_SHORT).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "Pound"  && spinner1.getSelectedItem().toString() == "Gram"){
                        tot = amount * 453.6;
                        Toast.makeText(Weight.this, "Value in Gram: "+tot+" gm", Toast.LENGTH_SHORT).show();                    }
                    else if (spinner.getSelectedItem().toString() == "Pound"  && spinner1.getSelectedItem().toString() == "Ounce"){
                        tot = amount * 16;
                        Toast.makeText(Weight.this, "Value in Ounce: "+tot, Toast.LENGTH_SHORT).show();                    }
                    //ounce
                    else if (spinner.getSelectedItem().toString() == "Ounce"  &&  spinner1.getSelectedItem().toString() == "KiloGram"){
                        tot = amount / 35.274;
                        Toast.makeText(Weight.this, "Value in KiloGram: "+tot+" kg", Toast.LENGTH_SHORT).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "Ounce"  && spinner1.getSelectedItem().toString() == "Gram"){
                        tot = amount * 28.35;
                        Toast.makeText(Weight.this, "Value in Gram: "+tot+" gm", Toast.LENGTH_SHORT).show();                    }
                    else if (spinner.getSelectedItem().toString() == "Ounce"  && spinner1.getSelectedItem().toString() == "Pound"){
                        tot = amount / 16;
                        Toast.makeText(Weight.this, "Value in Pound: "+tot, Toast.LENGTH_SHORT).show();                    }
                    else{
                        Toast.makeText(Weight.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    }

                }catch (NumberFormatException e){
                    Toast.makeText(Weight.this, "Please enter valid Weight.", Toast.LENGTH_SHORT).show();
                }


            }
        });




    }
}