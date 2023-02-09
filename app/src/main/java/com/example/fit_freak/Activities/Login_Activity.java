package com.example.fit_freak.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fit_freak.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Activity extends AppCompatActivity {
    private Button login, signup, login_sub;
    private ImageButton google, fb, twitter;
    private TextInputEditText us_name, pass;
    private TextView forgot;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser mUser;

    boolean isAllFieldsChecked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.button);
        signup = findViewById(R.id.button2);
        us_name = findViewById(R.id.user_name);
        pass = findViewById(R.id.password);
        login_sub = findViewById(R.id.button3);
//        google = findViewById(R.id.imageButton);
//        fb = findViewById(R.id.imageButton2);
//        twitter = findViewById(R.id.imageButton3);

        mAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2 = new Intent(Login_Activity.this, Signup_Activity.class);
                startActivity(in2);
                finish();
            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                mUser = firebaseAuth.getCurrentUser();

//                if (mUser != null) {
//                    Toast.makeText(Login_Activity.this, "Signed In", Toast.LENGTH_LONG).show();
//                    startActivity(new Intent(Login_Activity.this, Profile_main.class));
//                    finish();
//                }else {
//                    Toast.makeText(Login_Activity.this, "Not Signed In", Toast.LENGTH_LONG).show();
//                }




            }
        };


//        login_sub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent_login = new Intent(Login_Activity.this,User_detail.class);
//                startActivity(intent_login);
//                finish();
//            }
//        });

        login_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAllFieldsChecked = CheckAllFields();

                if (isAllFieldsChecked) {
                    if (!TextUtils.isEmpty(us_name.getText().toString())
                            && !TextUtils.isEmpty(pass.getText().toString())) {

                        String email = us_name.getText().toString();
                        String pwd = pass.getText().toString();

                        login(email, pwd);


                    } else {

                        us_name.setError("Incorrect Username");
                        pass.setError("Incorrect Password");

                    }
                }
            }
        });




    }

    private boolean CheckAllFields() {
        if (us_name.length() == 0) {
            us_name.setError("This field is required");
            return false;
        }

        if (pass.length() == 0) {
            pass.setError("Password is required");
            return false;
        } else if (pass.length() < 6) {
            pass.setError("Password must be minimum 6 characters");
            return false;
        }
        return true;
    }

    private void login(String email, String pwd) {

        mAuth.signInWithEmailAndPassword(email, pwd)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            //Yay!! We're in!
                            Toast.makeText(Login_Activity.this, "Signed in", Toast.LENGTH_LONG)
                                    .show();

                            startActivity(new Intent(Login_Activity.this, Dashboard_Activity.class));
                            finish();
                        }else {
                            // Not it!
                        }

                    }
                });

    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//
//        if (item.getItemId() == R.id.action_signout) {
//
//            mAuth.signOut();
//
//        }
//
//        return super.onOptionsItemSelected(item);
//
//
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}