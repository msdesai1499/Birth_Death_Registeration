package com.example.hp.birth_death_registeration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DFormDPActivity extends AppCompatActivity {

    private Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dform_dp);

        b1=(Button)findViewById(R.id.btback2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DFormDPActivity.this,DFormPActivity.class);
                startActivity(intent);
            }
        });

        b2=(Button)findViewById(R.id.btnext2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DFormDPActivity.this,DFormFActivity.class);
                startActivity(intent);
            }
        });

    }
}
