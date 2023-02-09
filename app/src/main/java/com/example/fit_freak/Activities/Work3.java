package com.example.fit_freak.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fit_freak.R;

import java.util.HashMap;

public class Work3 extends AppCompatActivity {
    private TextView ex1,ex2,ex3,ex4,ex5,ex6;
    private Button ne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work3);


        ex1 = findViewById(R.id.exeb1);
        ex2 = findViewById(R.id.exeb2);
        ex3 = findViewById(R.id.exeb3);
        ex4 = findViewById(R.id.exeb4);
        ex5 = findViewById(R.id.exeb5);
        ex6 = findViewById(R.id.exeb6);

        ne  = findViewById(R.id.wr4);

        HashMap<Integer,String> day1 = new HashMap<Integer, String>();
        day1.put(1,"Bench Press - 3X15");
        day1.put(2,"Incline DB Press - 3X12");
        day1.put(3,"Pec Fly - 3X12");
        day1.put(4,"DB Pullover - 3X12");
        day1.put(5,"Incline Fly - 3X12");
        day1.put(6,"DB Rotation - 3X12");

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
                Intent intent = new Intent(Work3.this, Work4.class);
                startActivity(intent);
            }
        });

    }
}