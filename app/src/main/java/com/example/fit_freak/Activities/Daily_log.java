package com.example.fit_freak.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.fit_freak.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Daily_log extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_log);

        bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.daily);

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
                        return true;
                    case R.id.tracker:
                        startActivity(new Intent(getApplicationContext(),SetTracker_Activity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }

        });

    }
}