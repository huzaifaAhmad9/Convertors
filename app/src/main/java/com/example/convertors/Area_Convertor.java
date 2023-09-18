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

public class Area_Convertor extends AppCompatActivity {
    LottieAnimationView animation;

    EditText time;
    Spinner spinner,spinner1;
    Button btn;
    ArrayList<String> arr = new ArrayList<>();
    ArrayList<String> arr1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_convertor);


        // set animation
        animation = findViewById(R.id.animation);
        animation.setAnimation(R.raw.lenght);
        animation.playAnimation();

        time = findViewById(R.id.time);
        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        btn = findViewById(R.id.btn);



        // adding elements in array
        arr.add("Acre");
        arr.add("Hectare");
        arr.add("Square Kilometre");
        arr.add("Square Foot");
        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arr);
        spinner.setAdapter(adp);


        // adding elements in array
        arr1.add("Acre");
        arr1.add("Hectare");
        arr1.add("Square Kilometre");
        arr1.add("Square Foot");
        ArrayAdapter<String> adp1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arr1);
        spinner1.setAdapter(adp1);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try{

                    Double tot;
                    Double amount = Double.parseDouble(time.getText().toString());

                    // Area_Convertor
                    if (spinner.getSelectedItem().toString() == "Acre" && spinner1.getSelectedItem().toString() == "Hectare"){
                        tot = amount / 2.471;
                        Toast.makeText(Area_Convertor.this, "Value in Hectare: "+tot, Toast.LENGTH_SHORT).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "Acre"  && spinner1.getSelectedItem().toString() == "Square Kilometre"){
                        tot = amount / 247.1;
                        Toast.makeText(Area_Convertor.this, "Value in Square Kilometre: "+tot, Toast.LENGTH_SHORT).show();                    }
                    else if (spinner.getSelectedItem().toString() == "Acre"  && spinner1.getSelectedItem().toString() == "Square foot "){
                        tot = amount * 43560;
                        Toast.makeText(Area_Convertor.this, "Value in Square Foot: "+tot, Toast.LENGTH_SHORT).show();                    }






                    //hectare
                    else if (spinner.getSelectedItem().toString() == "Hectare"  &&  spinner1.getSelectedItem().toString() == "Acre"){
                        tot = amount * 2.471;
                        Toast.makeText(Area_Convertor.this, "Value in Acre: "+tot, Toast.LENGTH_SHORT).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "Hectare"  && spinner1.getSelectedItem().toString() == "Square Kilometre"){
                        tot = amount / 100;
                        Toast.makeText(Area_Convertor.this, "Value in Square Kilometre: "+tot, Toast.LENGTH_SHORT).show();                    }
                    else if (spinner.getSelectedItem().toString() == "Hectare"  && spinner1.getSelectedItem().toString() == "Square Foot"){
                        tot = amount * 107600;
                        Toast.makeText(Area_Convertor.this, "Value in Square Foot: "+tot, Toast.LENGTH_SHORT).show();                    }






                    // square kilometre
                    else if (spinner.getSelectedItem().toString() == "Square Kilometre"  &&  spinner1.getSelectedItem().toString() == "Acre"){
                        tot = amount * 247.1;
                        Toast.makeText(Area_Convertor.this, "Value in Acre: "+tot, Toast.LENGTH_SHORT).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "Square Kilometre"  && spinner1.getSelectedItem().toString() == "Hectare"){
                        tot = amount * 100;
                        Toast.makeText(Area_Convertor.this, "Value in Hectare: "+tot, Toast.LENGTH_SHORT).show();                    }
                    else if (spinner.getSelectedItem().toString() == "Square Kilometre"  && spinner1.getSelectedItem().toString() == "Square Foot"){
                        tot = amount * 10760000;
                        Toast.makeText(Area_Convertor.this, "Value in Square Foot: "+tot, Toast.LENGTH_SHORT).show();                    }







                    //sqyare foot
                    else if (spinner.getSelectedItem().toString() == "Square Foot"  &&  spinner1.getSelectedItem().toString() == "Acre"){
                        tot = amount / 43560;
                        Toast.makeText(Area_Convertor.this, "Value in Acre: "+tot, Toast.LENGTH_SHORT).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "Square Foot"  && spinner1.getSelectedItem().toString() == "Hectare"){
                        tot = amount / 107600;
                        Toast.makeText(Area_Convertor.this, "Value in Hectare: "+tot, Toast.LENGTH_SHORT).show();                    }
                    else if (spinner.getSelectedItem().toString() == "Square Foot"  && spinner1.getSelectedItem().toString() == "Square Kilometre"){
                        tot = amount / 1076000;
                        Toast.makeText(Area_Convertor.this, "Value in Square Kilometre: "+tot, Toast.LENGTH_SHORT).show();                    }


                    else{
                        Toast.makeText(Area_Convertor.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    }

                }catch (NumberFormatException e){
                    Toast.makeText(Area_Convertor.this, "Please enter valid Value.", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}