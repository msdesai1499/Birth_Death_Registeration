package com.example.hp.birth_death_registeration;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DSignUpActivity extends AppCompatActivity {

    private Button bs1,blh;
    private EditText t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    DatabaseReference d= FirebaseDatabase.getInstance().getReference();
    FirebaseAuth fb;
    private AwesomeValidation awesomeValidation;
   // FirebaseUser fu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsign_up);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        t3=(EditText)findViewById(R.id.t3);
        t4=(EditText)findViewById(R.id.t4);
        t5=(EditText)findViewById(R.id.t5);
        t6=(EditText)findViewById(R.id.t6);
        t7=(EditText)findViewById(R.id.t7);
        t8=(EditText)findViewById(R.id.t8);
        t9=(EditText)findViewById(R.id.t9);
        t10=(EditText)findViewById(R.id.t10);
        t11=(EditText)findViewById(R.id.t11);
        bs1=(Button)findViewById(R.id.btnSignUp);
        blh=(Button)findViewById(R.id.lh);
        awesomeValidation.addValidation(this, R.id.t1, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.t2, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.t3, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.t4, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.t5, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.t7, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.t6, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
      //  awesomeValidation.addValidation(this, R.id.editTextDob, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.dateerror);

        fb=FirebaseAuth.getInstance();
        if (fb.getCurrentUser()!=null)
        {

        }
      //  fu=fb.getCurrentUser();


        bs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adddata();

            }
        });

        blh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate()) {
                    Intent intent = new Intent(DSignUpActivity.this, DLoginActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please enter correct values",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void adddata()
    {
        String s1=t1.getText().toString().trim();
        String s2=t2.getText().toString().trim();
        String s3=t3.getText().toString().trim();
        String s4=t4.getText().toString().trim();
        String s5=t5.getText().toString().trim();
        String s6=t6.getText().toString().trim();
        String s7=t7.getText().toString().trim();
        String s8=t8.getText().toString().trim();
        String s9=t9.getText().toString().trim();
        String s10=t10.getText().toString().trim();
        String s11=t11.getText().toString().trim();
        if (!s2.equals(s3)){
            t3.setError("password not matched");
t3.requestFocus();
return;
        }

        if(!TextUtils.isEmpty(s1)&&!TextUtils.isEmpty(s2)&&!TextUtils.isEmpty(s3) &&!TextUtils.isEmpty(s4)&&!TextUtils.isEmpty(s5)&&!TextUtils.isEmpty(s6)&&!TextUtils.isEmpty(s7)&&!TextUtils.isEmpty(s8)&&!TextUtils.isEmpty(s9)&&!TextUtils.isEmpty(s10)&&!TextUtils.isEmpty(s11))
        {
String id=d.push().getKey();
DoctorData d1=new DoctorData(id,s1,s2,s4,s5,s6,s7,s8,s9,s10,s11);
  d.child(" Doctor_signup").child(id).setValue(d1);
            Toast.makeText(DSignUpActivity.this,"Data saved ",Toast.LENGTH_SHORT).show();


            fb.createUserWithEmailAndPassword(s7,s2).addOnCompleteListener(DSignUpActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                      //  Toast.makeText(DSignUpActivity.this,"user registered succefully",Toast.LENGTH_SHORT).show();
                    }
                    Intent intent=new Intent(DSignUpActivity.this,DLoginActivity.class);
                    startActivity(intent);
                }
            });
        }
        else {
            Toast.makeText(DSignUpActivity.this,"Enter all fields ",Toast.LENGTH_SHORT).show();
        }
    }
}
