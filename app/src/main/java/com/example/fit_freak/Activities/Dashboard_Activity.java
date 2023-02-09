package com.example.fit_freak.Activities;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.tv.TvContract;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fit_freak.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Dashboard_Activity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private TextView cal;
    private ProgressBar progressBar;
    private Button workout, diet;
    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseUser mUser;
    private List<User> userList;
    private ImageView img;







    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
//        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
//        String day = (String) DateFormat.format("dd", Long.parseLong(date));

        workout = findViewById(R.id.workout_button);
        diet = findViewById(R.id.diet_button);
        img = findViewById(R.id.getdata);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        cal = findViewById(R.id.consume_calories);
        progressBar = findViewById(R.id.activeProgress);
        progressBar.setProgress(0);
        userList = new ArrayList<>();
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("MUsers");
        getdata();

//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String calorie = snapshot.child("bodytype").getValue().toString();
//                //cal.setText(calorie);
//                Toast.makeText(getApplicationContext(),calorie,Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


//        firebaseDatabase = FirebaseDatabase.getInstance();
//        databaseReference = firebaseDatabase.getReference().child("MUsers");
//        databaseReference.keepSynced(true);

//        DatabaseReference ref=FirebaseDatabase.getInstance().getReference();
//        ref = FirebaseDatabase.getInstance().getReference().child("MUsers").child("age");
//        DatabaseReference finalRef = ref;
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if(dataSnapshot.exists()){
//                    for(DataSnapshot ds: dataSnapshot.getChildren()){
//                        String userid=ds.child("username").getValue().toString();
//                        finalRef.child("MUsers").orderByKey().equalTo(userid).addValueEventListener(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(DataSnapshot dataSnapshot) {
//                                String fullname=dataSnapshot.child("full_name").getValue().toString();
//                            }
//                            @Override
//                            public void onCancelled(DatabaseError databaseError) {
//
//                            }
//                        });
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });






//
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("MUsers");
//
//        reference.orderByChild("calories").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for(DataSnapshot datas: dataSnapshot.getChildren()){
//                    String calories=datas.child("calories").getValue().toString();
//                    cal.setText(calories);
//                }
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });



        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard_Activity.this, Workout_Routine.class);
                startActivity(intent);
            }
        });

        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard_Activity.this, Customize_Diet.class);
                startActivity(intent);
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.home_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.reminders:
                        startActivity(new Intent(getApplicationContext(),SetReminder_Activity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home_nav:
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

    private void getdata() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){

                    String data = snapshot.child(mUser.getUid()).child("calories").getValue().toString();
                    //System.out.println(data);
                    cal.setText("Consume: "+data + " calories");

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Error");

            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_corner,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.profile){
            startActivity(new Intent(getApplicationContext(),Profile_main.class));
            overridePendingTransition(0,0);

        }
        if (id == R.id.setting){
            startActivity(new Intent(getApplicationContext(),Setting.class));
            overridePendingTransition(0,0);

        }
        if (id==R.id.add_photo){
            startActivity(new Intent(getApplicationContext(),Add_Photo.class));
            overridePendingTransition(0,0);

        }
        if (id == R.id.logout){
            startActivity(new Intent(getApplicationContext(),Login_Activity.class));
            overridePendingTransition(0,0);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


}