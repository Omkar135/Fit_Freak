package com.example.fit_freak.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.fit_freak.R;
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SetReminder_Activity extends AppCompatActivity {

    private CheckBox c1,c2,c3;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_reminder);


        c1 = findViewById(R.id.checkboxW);
        c2 = findViewById(R.id.checkboxM);
        c3 = findViewById(R.id.checkboxMR);


        if (c1.isChecked()){
            Toast.makeText(getApplicationContext(),"Reminder Set",Toast.LENGTH_LONG).show();
        }else if (c2.isChecked()){
            Toast.makeText(getApplicationContext(),"Morning Reminder Set",Toast.LENGTH_LONG).show();

        }else if (c3.isChecked()){
            Toast.makeText(getApplicationContext(),"Meal Reminder Set",Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(getApplicationContext(),"Nothing Set",Toast.LENGTH_LONG).show();

        }


        bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.reminders);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.reminders:
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
                        startActivity(new Intent(getApplicationContext(),SetTracker_Activity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }

        });

    }
}