package com.example.hp.birth_death_registeration;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class BirthCActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button btn;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birth_c);

        btn=(Button)findViewById(R.id.btnb);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BirthCActivity.this,BFormPActivity.class);
                startActivity(intent);
            }
        });

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView=(NavigationView)findViewById(R.id.nview3);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.home)
        {
            Intent intent=new Intent(BirthCActivity.this,HomeActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.birthC)
        {
            Intent intent=new Intent(BirthCActivity.this,BirthCActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.deathC)
        {
            Intent intent=new Intent(BirthCActivity.this,DeathCActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.about)
        {
            Intent intent=new Intent(BirthCActivity.this,AboutActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.help)
        {
            Intent intent=new Intent(BirthCActivity.this,HelpActivity.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
