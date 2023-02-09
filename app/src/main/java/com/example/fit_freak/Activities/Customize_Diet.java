package com.example.fit_freak.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.fit_freak.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Customize_Diet extends AppCompatActivity {

    private TextView meal1,meal2,meal3,meal4,meal5;
    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseUser mUser;
    String cals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_diet);

        databaseReference = FirebaseDatabase.getInstance().getReference("MUsers");

        meal1 = findViewById(R.id.m1);
        meal2 = findViewById(R.id.m2);
        meal3 = findViewById(R.id.m3);
        meal4 = findViewById(R.id.m4);
        meal5 = findViewById(R.id.m5);

        HashMap<Integer,String> bf_dietx1 = new HashMap<Integer, String>();
        bf_dietx1.put(400,"Consume 400 calories B/F");
        bf_dietx1.put(500,"Consume 500 calories B/F");
        bf_dietx1.put(600,"Consume 600 calories B/F");
        bf_dietx1.put(700,"Consume 700 calories B/F");
        bf_dietx1.put(800,"Consume 800 calories B/F");

        HashMap<Integer,String> l_dietx1 = new HashMap<Integer, String>();
        l_dietx1.put(500,"Consume 500 calories lunch");
        l_dietx1.put(600,"Consume 600 calories lunch");
        l_dietx1.put(700,"Consume 700 calories lunch");
        l_dietx1.put(800,"Consume 800 calories lunch");
        l_dietx1.put(900,"Consume 900 calories lunch");

        HashMap<Integer,String> prw_dietx1 = new HashMap<Integer, String>();
        prw_dietx1.put(200,"Consume 200 calories pre-workout");
        prw_dietx1.put(250,"Consume 250 calories pre-workout");
        prw_dietx1.put(300,"Consume 300 calories pre-workout");
        prw_dietx1.put(350,"Consume 350 calories pre-workout");
        prw_dietx1.put(400,"Consume 400 calories pre-workout");
        prw_dietx1.put(450,"Consume 450 calories pre-workout");

        HashMap<Integer,String> pow_dietx1 = new HashMap<Integer, String>();
        pow_dietx1.put(200,"Consume 200 calories post-workout");
        pow_dietx1.put(250,"Consume 250 calories post-workout");
        pow_dietx1.put(300,"Consume 300 calories post-workout");
        pow_dietx1.put(350,"Consume 350 calories post-workout");
        pow_dietx1.put(400,"Consume 400 calories post-workout");
        pow_dietx1.put(450,"Consume 450 calories post-workout");

        HashMap<Integer,String> d_dietx1 = new HashMap<Integer, String>();
        d_dietx1.put(700,"Consume 700 calories Dinner");
        d_dietx1.put(800,"Consume 800 calories Dinner");
        d_dietx1.put(900,"Consume 900 calories Dinner");



        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("MUsers");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){

                    String data = snapshot.child(mUser.getUid()).child("calories").getValue().toString();

                    cals = data;
                    //System.out.println(cals);

                    if (cals.equals("2000")){
                        meal1.setText(bf_dietx1.get(400));
                        meal2.setText(l_dietx1.get(500));
                        meal3.setText(prw_dietx1.get(200));
                        meal4.setText(pow_dietx1.get(200));
                        meal5.setText(d_dietx1.get(700));
                    }else if (cals.equals("2100")){
                        meal1.setText(bf_dietx1.get(400));
                        meal2.setText(l_dietx1.get(600));
                        meal3.setText(prw_dietx1.get(200));
                        meal4.setText(pow_dietx1.get(200));
                        meal5.setText(d_dietx1.get(700));
                    } else if (cals.equals("2200")){
                        meal1.setText(bf_dietx1.get(400));
                        meal2.setText(l_dietx1.get(700));
                        meal3.setText(prw_dietx1.get(200));
                        meal4.setText(pow_dietx1.get(200));
                        meal5.setText(d_dietx1.get(700));
                    }else if (cals.equals("2300")){
                        meal1.setText(bf_dietx1.get(400));
                        meal2.setText(l_dietx1.get(800));
                        meal3.setText(prw_dietx1.get(200));
                        meal4.setText(pow_dietx1.get(200));
                        meal5.setText(d_dietx1.get(700));
                    }else if (cals.equals("2400")){
                        meal1.setText(bf_dietx1.get(500));
                        meal2.setText(l_dietx1.get(800));
                        meal3.setText(prw_dietx1.get(200));
                        meal4.setText(pow_dietx1.get(200));
                        meal5.setText(d_dietx1.get(700));
                    }else if (cals.equals("2500")){
                        meal1.setText(bf_dietx1.get(600));
                        meal2.setText(l_dietx1.get(800));
                        meal3.setText(prw_dietx1.get(200));
                        meal4.setText(pow_dietx1.get(200));
                        meal5.setText(d_dietx1.get(700));
                    }else if (cals.equals("2600")){
                        meal1.setText(bf_dietx1.get(700));
                        meal2.setText(l_dietx1.get(800));
                        meal3.setText(prw_dietx1.get(200));
                        meal4.setText(pow_dietx1.get(200));
                        meal5.setText(d_dietx1.get(700));
                    }else if (cals.equals("2700")){
                        meal1.setText(bf_dietx1.get(600));
                        meal2.setText(l_dietx1.get(800));
                        meal3.setText(prw_dietx1.get(300));
                        meal4.setText(pow_dietx1.get(300));
                        meal5.setText(d_dietx1.get(700));
                    }else if (cals.equals("2800")){
                        meal1.setText(bf_dietx1.get(600));
                        meal2.setText(l_dietx1.get(800));
                        meal3.setText(prw_dietx1.get(350));
                        meal4.setText(pow_dietx1.get(350));
                        meal5.setText(d_dietx1.get(700));
                    }else if (cals.equals("2900")){
                        meal1.setText(bf_dietx1.get(600));
                        meal2.setText(l_dietx1.get(800));
                        meal3.setText(prw_dietx1.get(400));
                        meal4.setText(pow_dietx1.get(400));
                        meal5.setText(d_dietx1.get(700));
                    }else if (cals.equals("3000")){
                        meal1.setText(bf_dietx1.get(600));
                        meal2.setText(l_dietx1.get(800));
                        meal3.setText(prw_dietx1.get(450));
                        meal4.setText(pow_dietx1.get(450));
                        meal5.setText(d_dietx1.get(700));
                    }else if (cals.equals("3100")){
                        meal1.setText(bf_dietx1.get(700));
                        meal2.setText(l_dietx1.get(800));
                        meal3.setText(prw_dietx1.get(450));
                        meal4.setText(pow_dietx1.get(450));
                        meal5.setText(d_dietx1.get(700));
                    }else if (cals.equals("3200")){
                        meal1.setText(bf_dietx1.get(800));
                        meal2.setText(l_dietx1.get(800));
                        meal3.setText(prw_dietx1.get(450));
                        meal4.setText(pow_dietx1.get(450));
                        meal5.setText(d_dietx1.get(700));
                    }else if (cals.equals("3300")){
                        meal1.setText(bf_dietx1.get(800));
                        meal2.setText(l_dietx1.get(800));
                        meal3.setText(prw_dietx1.get(450));
                        meal4.setText(pow_dietx1.get(450));
                        meal5.setText(d_dietx1.get(800));
                    }else if (cals.equals("3400")){
                        meal1.setText(bf_dietx1.get(800));
                        meal2.setText(l_dietx1.get(800));
                        meal3.setText(prw_dietx1.get(450));
                        meal4.setText(pow_dietx1.get(450));
                        meal5.setText(d_dietx1.get(900));
                    }else if (cals.equals("3500")){
                        meal1.setText(bf_dietx1.get(800));
                        meal2.setText(l_dietx1.get(900));
                        meal3.setText(prw_dietx1.get(450));
                        meal4.setText(pow_dietx1.get(450));
                        meal5.setText(d_dietx1.get(900));
                    }else{
                        System.out.println("Incorrect Input!");
                    }



                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Error");

            }
        });






//        tweet = findViewById(R.id.twitter);
//        insta = findViewById(R.id.instagram);
//        spot = findViewById(R.id.spotify);
//
//        tweet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                gotoUrl("https://twitter.com/samihan_sawant");
//            }
//        });
//
//        insta.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                gotoUrl("https://www.instagram.com/samihan_sawant/?hl=en");
//            }
//        });
//
//        spot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                gotoUrl("https://open.spotify.com/playlist/0VvoGtu86T0SfXbtwBYL1k?si=6AexomDHR7KhGuo7YUj7jA&nd=1");
//            }
//        });
//
//    }
//
//    private void gotoUrl(String s) {
//        Uri uri = Uri.parse(s);
//        startActivity(new Intent(Intent.ACTION_VIEW,uri));
//    }
//
//


    }


}