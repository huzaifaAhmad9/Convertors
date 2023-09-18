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

public class Volume extends AppCompatActivity {



    LottieAnimationView animation;

    EditText time;
    Spinner spinner,spinner1;
    Button btn;
    ArrayList<String> arr = new ArrayList<>();
    ArrayList<String> arr1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);




        // set animation
        animation = findViewById(R.id.animation);
        animation.setAnimation(R.raw.lenght);
        animation.playAnimation();

        time = findViewById(R.id.time);
        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        btn = findViewById(R.id.btn);



        // adding elements in array
        arr.add("Gallon");
        arr.add("Litre");
        arr.add("CubicMetre");
        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arr);
        spinner.setAdapter(adp);


        // adding elements in array
        arr1.add("Gallon");
        arr1.add("Litre");
        arr1.add("CubicMetre");
        ArrayAdapter<String> adp1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arr1);
        spinner1.setAdapter(adp1);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try{

                    Double tot;
                    Double amount = Double.parseDouble(time.getText().toString());

                    // gallon
                    if (spinner.getSelectedItem().toString() == "Gallon" && spinner1.getSelectedItem().toString() == "Litre"){
                        tot = amount * 3.785;
                        Toast.makeText(Volume.this, "Value in Litre: "+tot, Toast.LENGTH_SHORT).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "Gallon"  && spinner1.getSelectedItem().toString() == "CubicMetre"){
                        tot = amount / 264.2;
                        Toast.makeText(Volume.this, "Value in CubicMetre: "+tot, Toast.LENGTH_SHORT).show();                    }
                    // litre
                    else if (spinner.getSelectedItem().toString() == "Litre"  &&  spinner1.getSelectedItem().toString() == "Gallon"){
                        tot = amount / 3.785;
                        Toast.makeText(Volume.this, "Value in Gallon: "+tot, Toast.LENGTH_SHORT).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "Litre"  && spinner1.getSelectedItem().toString() == "CubicMetre"){
                        tot = amount / 1000;
                        Toast.makeText(Volume.this, "Value in CubicMetre: "+tot, Toast.LENGTH_SHORT).show();                    }
                    // cubicmetre
                    else if (spinner.getSelectedItem().toString() == "CubicMetre"  && spinner1.getSelectedItem().toString() == "Litre"){
                        tot = amount * 1000;
                        Toast.makeText(Volume.this, "Value in Litre: "+tot, Toast.LENGTH_SHORT).show();                    }
                    else if (spinner.getSelectedItem().toString() == "CubicMetre"  && spinner1.getSelectedItem().toString() == "Gallon"){
                        tot = amount * 264.2;
                        Toast.makeText(Volume.this, "Value in Gallon: "+tot, Toast.LENGTH_SHORT).show();                    }
                    else{
                        Toast.makeText(Volume.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    }

                }catch (NumberFormatException e){
                    Toast.makeText(Volume.this, "Please enter valid Volume.", Toast.LENGTH_SHORT).show();
                }


            }
        });
        
    }
}