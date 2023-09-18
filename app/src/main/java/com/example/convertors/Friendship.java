package com.example.convertors;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import java.util.Random;

public class Friendship extends AppCompatActivity {

    LottieAnimationView animation;

    EditText temp,temp1;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendship);



        // set animation
        animation = findViewById(R.id.animation);
        animation.setAnimation(R.raw.friend);
        animation.playAnimation();


        temp = findViewById(R.id.temp);
        temp1 = findViewById(R.id.temp1);
        btn = findViewById(R.id.btn);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateFriendshipScore();
                clearEditTextFields();
            }
        });
    }


    private void calculateFriendshipScore() {

        try {
            String name1 = temp.getText().toString();
            String name2 = temp1.getText().toString();


            // Check if EditText fields are empty
            if (name1.isEmpty() || name2.isEmpty()) {
                // Display a toast message if either of the names is empty
                Toast.makeText(this, "Enter valid names", Toast.LENGTH_SHORT).show();
                return; // Exit the method early
            }

                // Generate a random friendship score between 0 and 100.
                Random random = new Random();
                int friendshipScore = random.nextInt(101);

                String result = String.valueOf(friendshipScore);
                Toast.makeText(this, "Friendship Score: " + friendshipScore + "%", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, "Enter Valid Name", Toast.LENGTH_SHORT).show();
        }
        }

// for clearing edit text after clicking button
    private void clearEditTextFields() {
        temp.setText("");
        temp1.setText("");
    }




}