package com.example.hp.birth_death_registeration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MOSignupAct extends AppCompatActivity {

    private Button bs1,blh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mosignup);

        bs1=(Button)findViewById(R.id.mobtnsignup);
        blh=(Button)findViewById(R.id.lh);

        bs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MOSignupAct.this,MOLoginActivity.class);
                startActivity(intent);
            }
        });

        blh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MOSignupAct.this, MOLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
