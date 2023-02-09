package com.example.fit_freak.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.fit_freak.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SetTracker_Activity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    private Button track;
    private CheckBox c1,c2,c3,c4,c5,c6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_tracker);

        track = findViewById(R.id.track_save);

        c1 = findViewById(R.id.checkbox1);
        c2 = findViewById(R.id.checkbox2);
        c3 = findViewById(R.id.checkbox3);
        c4 = findViewById(R.id.checkbox4);
        c5 = findViewById(R.id.checkbox5);
        c6 = findViewById(R.id.checkbox6);

        bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.tracker);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.reminders:
                        startActivity(new Intent(getApplicationContext(),SetReminder_Activity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home_nav:
                        startActivity(new Intent(getApplicationContext(),Dashboard_Activity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.daily:
                        startActivity(new Intent(getApplicationContext(),Daily_log.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.tracker:
                        return true;
                }
                return false;
            }

        });

        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (c1.isChecked()){
                    Toast.makeText(getApplicationContext(),"Sleep Cycle saved",Toast.LENGTH_LONG).show();
                }else if (c2.isChecked() || c3.isChecked() || c4.isChecked() || c5.isChecked() || c6.isChecked()){
                    Toast.makeText(getApplicationContext(),"Diet saved",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Nothing Saved",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}