package com.example.hp.birth_death_registeration;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DBNotificationActivity extends AppCompatActivity {
    DatabaseReference db1 = FirebaseDatabase.getInstance().getReference();
    DatabaseReference db2=db1.child("user").getRef();
    ListView l1;
    List<userlogin> list1;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbnotification);

        b1 = (Button) findViewById(R.id.close1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l1 = findViewById(R.id.listview);
                list1 = new ArrayList<>();

                db2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        list1.clear();
                        for (DataSnapshot as1 : dataSnapshot.getChildren()) {
                            userlogin e = as1.getValue(userlogin.class);

                                list1.add(e);

                        }

                        EntryList e1 = new EntryList(DBNotificationActivity.this, list1);
                        l1.setAdapter(e1);


                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }});

            }});


    }
}





