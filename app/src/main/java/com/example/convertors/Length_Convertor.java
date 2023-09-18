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

public class Length_Convertor extends AppCompatActivity {

    LottieAnimationView animation;

    EditText time;
    Spinner spinner,spinner1;
    Button btn;
    ArrayList<String> arr = new ArrayList<>();
    ArrayList<String> arr1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_convertor);





        // set animation
        animation = findViewById(R.id.animation);
        animation.setAnimation(R.raw.lenght);
        animation.playAnimation();

        time = findViewById(R.id.time);
        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        btn = findViewById(R.id.btn);



        // adding elements in array
        arr.add("Metre");
        arr.add("CentiMetre");
        arr.add("MilliMetre");
        arr.add("Inch");
        arr.add("Foot");
        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arr);
        spinner.setAdapter(adp);


        // adding elements in array
        arr1.add("Metre");
        arr1.add("CentiMetre");
        arr1.add("MilliMetre");
        arr1.add("Inch");
        arr1.add("Foot");
        ArrayAdapter<String> adp1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arr1);
        spinner1.setAdapter(adp1);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try{

                    Double tot;
                    Double amount = Double.parseDouble(time.getText().toString());

                    // metre
                    if (spinner.getSelectedItem().toString() == "Metre" && spinner1.getSelectedItem().toString() == "CentiMetre"){
                        tot = amount * 100;
                        Toast.makeText(Length_Convertor.this, "Value in CentiMtere: "+tot+" cm", Toast.LENGTH_SHORT).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "Metre"  && spinner1.getSelectedItem().toString() == "MilliMetre"){
                        tot = amount * 1000;
                        Toast.makeText(Length_Convertor.this, "Value in MilliMetre: "+tot+" mm", Toast.LENGTH_SHORT).show();                    }
                    else if (spinner.getSelectedItem().toString() == "Metre"  && spinner1.getSelectedItem().toString() == "Inch"){
                        tot = amount * 39.37;
                        Toast.makeText(Length_Convertor.this, "Value in Inch: "+tot+" in", Toast.LENGTH_SHORT).show();                    }
                    else if (spinner.getSelectedItem().toString() == "Metre"  && spinner1.getSelectedItem().toString() == "Foot"){
                        tot = amount * 3.281;
                        Toast.makeText(Length_Convertor.this, "Value in Foot: "+tot+" ft", Toast.LENGTH_SHORT).show();                    }
                    //centimetre
                    else if (spinner.getSelectedItem().toString() == "CentiMetre"  &&  spinner1.getSelectedItem().toString() == "Metre"){
                        tot = amount / 100;
                        Toast.makeText(Length_Convertor.this, "Value in Metere: "+tot+" m", Toast.LENGTH_SHORT).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "CentiMetre"  && spinner1.getSelectedItem().toString() == "MilliMetre"){
                        tot = amount * 10;
                        Toast.makeText(Length_Convertor.this, "Value in MilliMetre: "+tot+" mm", Toast.LENGTH_SHORT).show();                    }
                    else if (spinner.getSelectedItem().toString() == "CentiMetre"  && spinner1.getSelectedItem().toString() == "Inch"){
                        tot = amount / 2.54;
                        Toast.makeText(Length_Convertor.this, "Value in Inch: "+tot+" in", Toast.LENGTH_SHORT).show();                    }
                    else if (spinner.getSelectedItem().toString() == "CentiMetre"  && spinner1.getSelectedItem().toString() == "Foot"){
                        tot = amount / 30.48;
                        Toast.makeText(Length_Convertor.this, "Value in Foot: "+tot+" ft", Toast.LENGTH_SHORT).show();                    }
                    //milliimetre
                    else if (spinner.getSelectedItem().toString() == "MilliMetre"  &&  spinner1.getSelectedItem().toString() == "Metre"){
                        tot = amount / 1000;
                        Toast.makeText(Length_Convertor.this, "Value in Metere: "+tot+" m", Toast.LENGTH_SHORT).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "MilliMetre"  && spinner1.getSelectedItem().toString() == "CentiMetre"){
                        tot = amount / 10;
                        Toast.makeText(Length_Convertor.this, "Value in CentiMetre: "+tot+" cm", Toast.LENGTH_SHORT).show();                    }
                    else if (spinner.getSelectedItem().toString() == "MilliMetre"  && spinner1.getSelectedItem().toString() == "Inch"){
                        tot = amount / 25.4;
                        Toast.makeText(Length_Convertor.this, "Value in Inch: "+tot+" in", Toast.LENGTH_SHORT).show();                    }
                    else if (spinner.getSelectedItem().toString() == "MilliMetre"  && spinner1.getSelectedItem().toString() == "Foot"){
                        tot = amount / 304.8;
                        Toast.makeText(Length_Convertor.this, "Value in Foot: "+tot+" ft", Toast.LENGTH_SHORT).show();                    }
                    //inch
                    else if (spinner.getSelectedItem().toString() == "Inch"  &&  spinner1.getSelectedItem().toString() == "Metre"){
                        tot = amount / 39.37;
                        Toast.makeText(Length_Convertor.this, "Value in Metere: "+tot+" m", Toast.LENGTH_SHORT).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "Inch"  && spinner1.getSelectedItem().toString() == "CentiMetre"){
                        tot = amount * 2.54;
                        Toast.makeText(Length_Convertor.this, "Value in CentiMetre: "+tot+" cm", Toast.LENGTH_SHORT).show();                    }
                    else if (spinner.getSelectedItem().toString() == "Inch"  && spinner1.getSelectedItem().toString() == "MilliMetre"){
                        tot = amount * 25.4;
                        Toast.makeText(Length_Convertor.this, "Value in MilliMetre: "+tot+" mm", Toast.LENGTH_SHORT).show();                    }
                    else if (spinner.getSelectedItem().toString() == "Inch"  && spinner1.getSelectedItem().toString() == "Foot"){
                        tot = amount / 12;
                        Toast.makeText(Length_Convertor.this, "Value in Foot: "+tot+" ft", Toast.LENGTH_SHORT).show();                    }
                    //foot
                    else if (spinner.getSelectedItem().toString() == "Foot"  &&  spinner1.getSelectedItem().toString() == "Metre"){
                        tot = amount / 3.281;
                        Toast.makeText(Length_Convertor.this, "Value in Metere: "+tot+" m", Toast.LENGTH_SHORT).show();
                    }
                    else if (spinner.getSelectedItem().toString() == "Foot"  && spinner1.getSelectedItem().toString() == "CentiMetre"){
                        tot = amount * 30.48;
                        Toast.makeText(Length_Convertor.this, "Value in CentiMetre: "+tot+" cm", Toast.LENGTH_SHORT).show();                    }
                    else if (spinner.getSelectedItem().toString() == "Foot"  && spinner1.getSelectedItem().toString() == "MilliMetre"){
                        tot = amount * 304.8;
                        Toast.makeText(Length_Convertor.this, "Value in MilliMetre: "+tot+" mm", Toast.LENGTH_SHORT).show();                    }
                    else if (spinner.getSelectedItem().toString() == "Foot"  && spinner1.getSelectedItem().toString() == "Inch"){
                        tot = amount * 12;
                        Toast.makeText(Length_Convertor.this, "Value in Inch: "+tot+" in", Toast.LENGTH_SHORT).show();                    }
                    else{
                        Toast.makeText(Length_Convertor.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    }

                }catch (NumberFormatException e){
                    Toast.makeText(Length_Convertor.this, "Please enter valid Lenght.", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}