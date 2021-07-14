package com.example.hp.birth_death_registeration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MOForgetPsswordActivity extends AppCompatActivity {

    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moforget_pssword);

        b1=(Button)findViewById(R.id.btncp);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MOForgetPsswordActivity.this,MOChangeActivity.class);
                startActivity(intent);
            }
        });
    }
}
