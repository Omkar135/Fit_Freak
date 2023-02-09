package com.example.fit_freak.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.fit_freak.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class User_detail extends AppCompatActivity {

    private Button save_next;
    private RadioGroup Gender, Body_type, Target;
    private RadioButton gen_m,gen_f,ecto,meso,endo,loss,gain;
    private TextInputEditText weight, height, age;
    private EditText medical;
    //boolean isAllFieldsChecked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);



        save_next = findViewById(R.id.save_btn);
        Gender = findViewById(R.id.gender_grp);
        Body_type = findViewById(R.id.body_grp);
        ecto = findViewById(R.id.ecto);
        meso = findViewById(R.id.meso);
        endo = findViewById(R.id.endo);
        Target = findViewById(R.id.target_grp);
        loss = findViewById(R.id.fat_loss);
        gain = findViewById(R.id.weight_gain);
        weight = findViewById(R.id.Weight);
        height = findViewById(R.id.height);
        age = findViewById(R.id.age);
        medical = findViewById(R.id.medical);

        gen_m = findViewById(R.id.male);
        gen_f = findViewById(R.id.female);






        save_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addValue();

            }
        });



    }


    void addValue(){
        String m1 = gen_m.getText().toString();
        String m2 = gen_f.getText().toString();
        String b1 = ecto.getText().toString();
        String b2 = meso.getText().toString();
        String b3 = endo.getText().toString();
        String g1 = loss.getText().toString();
        String g2 = gain.getText().toString();


        if (gen_m.isChecked()){
            User.setGender(m1);
        }else{
            User.setGender(m2);
        }


        User.setWeight(Double.parseDouble(weight.getText().toString()));
        User.setHeight(Integer.parseInt(height.getText().toString()));
        User.setAge(Integer.parseInt(age.getText().toString()));
        User.setMedical(medical.getText().toString());

        if (ecto.isChecked()){
            User.setBodytype(b1);
        }else if (meso.isChecked()){
            User.setBodytype(b2);
        }else{
            User.setBodytype(b3);
        }

        if (loss.isChecked()){

            User.setTarget(g1);

        }else{
            User.setTarget(g2);
        }

//        isAllFieldsChecked = CheckAllFields();
//
//        if (isAllFieldsChecked) {

            Intent intentplan = new Intent(User_detail.this, Plan_Activity.class);
            startActivity(intentplan);



    }

//        private boolean CheckAllFields() {
//
//            if (weight.length() == 0) {
//                weight.setError("This field is required");
//                return false;
//            }
//
//            if (height.length() == 0) {
//                height.setError("This field is required");
//                return false;
//            }
//            if (age.length() == 0) {
//                age.setError("This field is required");
//                return false;
//            }
//            if (medical.length() == 0) {
//                medical.setError("This field is required");
//                return false;
//            }
//
//            return true;
//        }

}

