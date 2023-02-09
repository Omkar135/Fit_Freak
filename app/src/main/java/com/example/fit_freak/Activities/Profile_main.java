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

public class Profile_main extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseUser mUser;

    private TextView Usname,uage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_main);

        Usname = findViewById(R.id.u_name);
        uage = findViewById(R.id.u_age);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("MUsers");
        getdata();
    }
    private void getdata() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){

                    String ndata = snapshot.child(mUser.getUid()).child("fname").getValue().toString();
                    String edata = snapshot.child(mUser.getUid()).child("username").getValue().toString();
                    //System.out.println(data);
                    Usname.setText(ndata);
                    uage.setText(edata);





                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Error");

            }
        });
    }
}