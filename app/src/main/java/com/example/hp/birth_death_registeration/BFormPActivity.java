package com.example.hp.birth_death_registeration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BFormPActivity extends AppCompatActivity {

    private Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bform_p);

        b1=(Button)findViewById(R.id.btbackb);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BFormPActivity.this,BirthCActivity.class);
                startActivity(intent);
            }
        });

        b2=(Button)findViewById(R.id.btnextb);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BFormPActivity.this,BFormCActivity.class);
                startActivity(intent);
            }
        });


    }
}
