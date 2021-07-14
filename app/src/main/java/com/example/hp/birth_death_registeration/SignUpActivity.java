package com.example.hp.birth_death_registeration;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private Button bs1,blh;
boolean flg;
    private EditText un,pass,repass,name,add,phone,email,acard;

    DatabaseReference db=FirebaseDatabase.getInstance().getReference();
    FirebaseAuth fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        bs1=(Button)findViewById(R.id.mobtnsignup);
        blh=(Button)findViewById(R.id.lh);

        un=(EditText)findViewById(R.id.uusername);
        pass=(EditText)findViewById(R.id.upassword);
        repass=(EditText)findViewById(R.id.urepassword);
        name=(EditText)findViewById(R.id.uname);
        add=(EditText)findViewById(R.id.uaddress);
        phone=(EditText)findViewById(R.id.uphone);
        email=(EditText)findViewById(R.id.uemail);
        acard=(EditText)findViewById(R.id.uacard);
        fb=FirebaseAuth.getInstance();
        if (fb.getCurrentUser()!=null)
        {

        }

        bs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sun=un.getText().toString().trim();
                String spass=pass.getText().toString().trim();
                String srepass=repass.getText().toString().trim();
                String sname=name.getText().toString().trim();
                String sadd=add.getText().toString().trim();
                String sphone=phone.getText().toString().trim();
                String semail=email.getText().toString().trim();
                String sacard=acard.getText().toString().trim();
if (!spass.equals(srepass)){
    repass.setError("password not matched");
    repass.requestFocus();
    return;
}
                String sid=db.push().getKey();
String s="user";
flg=true;
                userlogin e=new userlogin(sid,sun,spass,srepass,sname,sadd,sphone,semail,sacard,flg);
                db.child(s).child(sid).setValue(e);
                Toast.makeText(SignUpActivity.this,"Record saved",Toast.LENGTH_SHORT).show();
                fb.createUserWithEmailAndPassword(semail,srepass).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(SignUpActivity.this,"user registered succefully",Toast.LENGTH_SHORT).show();
                        }

                    }
                });

                Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        blh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
