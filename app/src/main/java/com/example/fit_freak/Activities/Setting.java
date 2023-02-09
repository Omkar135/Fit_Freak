package com.example.fit_freak.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fit_freak.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Setting extends AppCompatActivity {

    private TextInputEditText name, weight,email;
    private TextView usname,fname;
    private Button save_btn;
    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        name = findViewById(R.id.change_name);
        weight = findViewById(R.id.change_weight);
        email = findViewById(R.id.change_mail);
        save_btn = findViewById(R.id.save_settings);

        usname = findViewById(R.id.user_name);
        fname = findViewById(R.id.user_email);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("MUsers");
        getdata();


        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatedata();

            }
        });



    }

    private void updatedata() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){

                    snapshot.getRef().child(mUser.getUid()).child("fname").setValue(name.getText().toString());
                    snapshot.getRef().child(mUser.getUid()).child("username").setValue(email.getText().toString());
                    snapshot.getRef().child(mUser.getUid()).child("weight").setValue(weight.getText().toString());
                    Toast.makeText(getApplicationContext(),"Profile Updated",Toast.LENGTH_LONG).show();


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Error");

            }
        });

    }

    private void getdata() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){

                    String ndata = snapshot.child(mUser.getUid()).child("fname").getValue().toString();
                    String edata = snapshot.child(mUser.getUid()).child("username").getValue().toString();
                    String wdata = snapshot.child(mUser.getUid()).child("weight").getValue().toString();
                    //System.out.println(data);
                    fname.setText(ndata);
                    usname.setText(edata);





                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Error");

            }
        });
    }


}