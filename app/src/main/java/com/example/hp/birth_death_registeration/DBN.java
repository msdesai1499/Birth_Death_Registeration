package com.example.hp.birth_death_registeration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class DBN extends AppCompatActivity {
    DatabaseReference db= FirebaseDatabase.getInstance().getReference();
    ListView l1;
    List<DoctorData> list1;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbn);
        b1=(Button)findViewById(R.id.close1);

    }
}
