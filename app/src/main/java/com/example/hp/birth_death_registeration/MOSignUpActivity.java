package com.example.hp.birth_death_registeration;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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

public class MOSignUpActivity extends AppCompatActivity {
    DatabaseReference modb = FirebaseDatabase.getInstance().getReference();
    Button bs1, blh;
    public String id, sname, semail, spass, sreg, saddre, sregno, sphnno;
    private EditText name, email, pass, reg, addre, regno, phnno, con;
    FirebaseAuth fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mosignup);
        bs1 = (Button) findViewById(R.id.mobtnsignup1);
        blh = (Button) findViewById(R.id.moback1);
        name = (EditText) findViewById(R.id.moname1);
        email = (EditText) findViewById(R.id.momail1);
        pass = (EditText) findViewById(R.id.mopass1);
        con = (EditText) findViewById(R.id.moconfirm1);
        reg = (EditText) findViewById(R.id.moreg1);
        addre = (EditText) findViewById(R.id.moaddr1);
        regno = (EditText) findViewById(R.id.moregno1);
        phnno = (EditText) findViewById(R.id.mophnno1);
        fb = FirebaseAuth.getInstance();
        if (fb.getCurrentUser() != null) {
        }

        bs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();

            }
        });

        blh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moints = new Intent(MOSignUpActivity.this, MOLoginActivity.class);
                startActivity(moints);
            }
        });
    }

    public void add() {
        sname = name.getText().toString().trim();
        semail = email.getText().toString().trim();
        spass = pass.getText().toString().trim();
        sreg = reg.getText().toString().trim();
        sregno = regno.getText().toString().trim();
        saddre = addre.getText().toString().trim();
        sphnno = phnno.getText().toString().trim();

        String con1 = con.getText().toString().trim();

        if (!con1.equals(spass)) {
            con.setError("password not matched");
            con.requestFocus();
            return;
        }
        if (!TextUtils.isEmpty(sname) && !TextUtils.isEmpty(semail) && !TextUtils.isEmpty(spass) && !TextUtils.isEmpty(sreg) && !TextUtils.isEmpty(sregno) && !TextUtils.isEmpty(saddre) && !TextUtils.isEmpty(sphnno)) {
            {
                id = modb.push().getKey();

                mosignup m = new mosignup(id, sname, semail, spass, sreg, saddre, sregno, sphnno);
                modb.child("Municipal_Office_Logins").child(id).setValue(m);
                Toast.makeText(MOSignUpActivity.this, "data saved", Toast.LENGTH_SHORT).show();

                fb.createUserWithEmailAndPassword(semail, spass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //  Toast.makeText(MOSignUpActivity.this," saved",Toast.LENGTH_SHORT).show();
                        }


                        Intent mointent = new Intent(MOSignUpActivity.this, MOLoginActivity.class);
                        startActivity(mointent);
                    }
                });

            }

        } else {
            Toast.makeText(MOSignUpActivity.this,"Enter all fields ",Toast.LENGTH_SHORT).show();
        }
    }

}