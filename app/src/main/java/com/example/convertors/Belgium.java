package com.example.convertors;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Belgium extends AppCompatActivity {
    EditText editTextBelgiumTime;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belgium);

        editTextBelgiumTime = findViewById(R.id.editTextBelgiumTime);
        btn = findViewById(R.id.btn);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String belgiumTimeStr = editTextBelgiumTime.getText().toString();

                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
                dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+2")); // Belgium (GMT+2)

                try {
                    Date belgiumTime = dateFormat.parse(belgiumTimeStr);
                    dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+5")); // Pakistan (GMT+5)
                    String pakistanTimeStr = dateFormat.format(belgiumTime);

                    Toast.makeText(Belgium.this, "Pakistan Time: "+pakistanTimeStr , Toast.LENGTH_SHORT).show();
                } catch (ParseException e) {
                    e.printStackTrace();
                    Toast.makeText(Belgium.this, "Invalid time format.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}