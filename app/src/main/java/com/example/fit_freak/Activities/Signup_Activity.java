package com.example.fit_freak.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.fit_freak.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup_Activity extends AppCompatActivity {
    private Button login, signup, login_sub;
    private ImageButton google, fb, twitter;
    private TextInputEditText us_name, pass,fname, conf_pass;
    private EditText med;

    private DatabaseReference mdatabaseref;
    private FirebaseAuth mfireauth;
    private FirebaseDatabase mfirebasedata;
    private ProgressDialog mprogress;

    //boolean isAllFieldsChecked = false;

    /*User user = new User();*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mfirebasedata = FirebaseDatabase.getInstance();
        mfireauth = FirebaseAuth.getInstance();
        mdatabaseref = mfirebasedata.getReference().child("MUsers");



        fname = findViewById(R.id.name);
        login = findViewById(R.id.button);
        signup = findViewById(R.id.button2);
        us_name = findViewById(R.id.user_name);
        pass = findViewById(R.id.password);
        conf_pass = findViewById(R.id.confirm_pass);
        login_sub = findViewById(R.id.button3);
//        a


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2 = new Intent(Signup_Activity.this, Login_Activity.class);
                startActivity(in2);
                finish();
            }
        });
        
        login_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                isAllFieldsChecked = CheckAllFields();

//                if (isAllFieldsChecked){
                    User.setUsername(us_name.getText().toString());
                    User.setName(fname.getText().toString());
                    User.setPassword(pass.getText().toString());
                    User.setCon_password(conf_pass.getText().toString());

                    String p = User.getPassword().toString();
                    String c = User.getPassword().toString();

//                    if (p == c){
                        Intent in2 = new Intent(Signup_Activity.this, User_detail.class);
                        startActivity(in2);
//                    }else {
//                        conf_pass.setError("Password should match");
//                        //Toast.makeText(getApplicationContext(),"Password should match",Toast.LENGTH_LONG).show();
//                    }



                }



        });
    }

//    private boolean CheckAllFields() {
//
//        if (us_name.length() == 0) {
//            us_name.setError("This field is required");
//            return false;
//        }
//
//        if (fname.length() == 0) {
//            fname.setError("This field is required");
//            return false;
//        }
//
//
//        if (pass.length() == 0) {
//            pass.setError("Password is required");
//            return false;
//        } else if (pass.length() < 6) {
//            pass.setError("Password must be minimum 6 characters");
//            return false;
//        }
//
//        if (conf_pass.length() == 0) {
//            conf_pass.setError("Password is required");
//            return false;
//        } else if (conf_pass.length() < 6) {
//            conf_pass.setError("Password must be minimum 6 characters");
//            return false;
//        }
//
//
//        return true;
//
//    }


}