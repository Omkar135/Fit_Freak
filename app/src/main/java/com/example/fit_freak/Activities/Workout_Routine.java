package com.example.fit_freak.Activities;

import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.UiAutomation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fit_freak.R;

import java.util.HashMap;

public class Workout_Routine extends AppCompatActivity {

    private TextView ex1,ex2,ex3,ex4,ex5,ex6;
    private Button ne,ds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_routine);

        ex1 = findViewById(R.id.exe1);
        ex2 = findViewById(R.id.exe2);
        ex3 = findViewById(R.id.exe3);
        ex4 = findViewById(R.id.exe4);
        ex5 = findViewById(R.id.exe5);
        ex6 = findViewById(R.id.exe6);

        ne  = findViewById(R.id.wr1);
        ds  = findViewById(R.id.dash1);


        HashMap<Integer,String> day1 = new HashMap<Integer, String>();
        day1.put(1,"Push up - 2X15");
        day1.put(2,"Pull up - 2X10");
        day1.put(3,"barbell curl - 3X12");
        day1.put(4,"hammer curl - 3X12");
        day1.put(5,"Preacher curl - 3X12");
        day1.put(6,"Cable curl - 3X12");

        ex1.setText(day1.get(1));
        ex2.setText(day1.get(2));
        ex3.setText(day1.get(3));
        ex4.setText(day1.get(4));
        ex5.setText(day1.get(5));
        ex6.setText(day1.get(6));

        ne.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Workout_Routine.this, Work1.class);
                startActivity(intent);
            }
        });

        ds.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Workout_Routine.this, Dashboard_Activity.class);
                startActivity(intent);
            }
        });



    }
}