package com.example.fit_freak.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.fit_freak.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Plan_Activity extends  AppCompatActivity{
    private Button profile_btn;

    private RadioGroup diet_p, workout_p, workout_i;
    private RadioButton veg,egg,nonveg,home,gym, beginner,intermediate,advance;


    private DatabaseReference mdatabaseref;
    private FirebaseAuth mfireauth;
    private FirebaseDatabase mfirebasedata;
    private ProgressDialog mprogress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        diet_p = findViewById(R.id.diet_plan);
        workout_p = findViewById(R.id.workout_plan);
        workout_i = findViewById(R.id.intensity);
        veg = findViewById(R.id.veg);
        egg = findViewById(R.id.egg);
        nonveg = findViewById(R.id.nonveg);
        home = findViewById(R.id.home_plan);
        gym = findViewById(R.id.gym_plan);
        beginner = findViewById(R.id.beginner);
        intermediate = findViewById(R.id.intermediate);
        advance = findViewById(R.id.advance);


        mfirebasedata = FirebaseDatabase.getInstance();
        mfireauth = FirebaseAuth.getInstance();
        mdatabaseref = mfirebasedata.getReference().child("MUsers");

        profile_btn = findViewById(R.id.button_pro);
        mprogress = new ProgressDialog(this);

//        Toast.makeText(getApplicationContext(), (int) User.getAge()+" "+User.getHeight()+" "+User.getWeight(),Toast.LENGTH_LONG).show();

        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String d1 = veg.getText().toString();
                String d2 = egg.getText().toString();
                String d3 = nonveg.getText().toString();
                String w1 = home.getText().toString();
                String w2 = gym.getText().toString();
                String i1 = beginner.getText().toString();
                String i2 = intermediate.getText().toString();
                String i3 = advance.getText().toString();

                if (veg.isChecked()){
                    User.setDiet_plan(d1);
                }else if(egg.isChecked()){
                    User.setDiet_plan(d2);
                }else{
                    User.setDiet_plan(d3);
                }

                if (home.isChecked()){
                    User.setWorkout(w1);
                }else{
                    User.setWorkout(w2);
                }

                if (beginner.isChecked()){
                    User.setIntensity(i1);
                }else if(intermediate.isChecked()){
                    User.setIntensity(i2);
                }else{
                    User.setIntensity(i3);
                }

                //calculateUserCalories();

                createAccount();

               /*Intent intent_dash = new Intent(Plan_Activity.this, Dashboard_Activity.class);
               startActivity(intent_dash);*/

            }
        });




    }

//    private void calculateUserCalories() {
//
//        String gender = User.getGender();
//        double weight = User.getWeight();
//        int height =User.getHeight();
//        int age = User.getAge();
//        String intensity = User.getIntensity();
//
//
//    }


    private void createAccount() {

         //Null
        String username = User.getUsername();//Name
        String name = User.getName();
        String passw = User.getPassword();
        String passcon = User.getCon_password();
        String gender = User.getGender();
        double weight = User.getWeight();
        int height =User.getHeight();
        int age = User.getAge();
        String bodytype = User.getBodytype();
        String medical = User.getMedical();
        String target = User.getTarget();
        String workout = User.getWorkout();
        String diet_plan = User.getDiet_plan();
        String intensity = User.getIntensity();


        //Toast.makeText(getApplicationContext(), (int) User.getCalories(),Toast.LENGTH_LONG).show();



        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        User.setDate(date);

        int BMR = 0;

        if (gender == "Male") {
            //Revised Harris-Benedict Equation
            BMR = (int) ((13.397 * weight) + (4.799 * height) - (5.677 * age) + 88.362);
        } else {
            BMR = (int) ((9.247 * weight) + (3.098 * height) - (4.330 * age) + 447.593);
        }


        double cal = 0;
        switch (intensity) {
            case "Beginner":
                cal = BMR * 1.375;
                break;
            case "Intermediate":
                cal = BMR * 1.6;
                break;
            case "Advance":
                cal = BMR * 1.9;
                break;
            default:
                System.out.println("Invalid Selection");

        }



        double pro_cal = weight * 2 * 4;
        double fat_cal = weight * (0.88) * 4;

        double r_cal = cal % 100.00;

        cal = cal - r_cal;


        if (User.getTarget() == "Fat Loss") {

            cal = cal - 200;
            User.setCalories(cal);

        } else if (User.getTarget() == "Weight Gain") {

            cal = cal + 200;
            User.setCalories(cal);

        }

        double calories = cal;



        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(username) && !TextUtils.isEmpty(passw) && !TextUtils.isEmpty(passcon)){
            mprogress.setMessage("Creating Account...");
            mprogress.show();

            mfireauth.createUserWithEmailAndPassword(username,passw).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    if (authResult != null){
                        String userid = mfireauth.getCurrentUser().getUid();
                        DatabaseReference currentuser = mdatabaseref.child(userid);

                        currentuser.child("fname").setValue(name);
                        currentuser.child("username").setValue(username);
                        currentuser.child("gender").setValue(gender);
                        currentuser.child("weight").setValue(weight);
                        currentuser.child("height").setValue(height);
                        currentuser.child("age").setValue(age);
                        currentuser.child("bodytype").setValue(bodytype);
                        currentuser.child("medical").setValue(medical);
                        currentuser.child("target").setValue(target);
                        currentuser.child("diet_plan").setValue(diet_plan);
                        currentuser.child("workout").setValue(workout);
                        currentuser.child("intensity").setValue(intensity);
                        currentuser.child("date").setValue(date);
                        currentuser.child("calories").setValue(calories);


                        mprogress.dismiss();

                        Intent intent = new Intent(Plan_Activity.this, Login_Activity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);

                    }
                }
            });


        }


    }


}






