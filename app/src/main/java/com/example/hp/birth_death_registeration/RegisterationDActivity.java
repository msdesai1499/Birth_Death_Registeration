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

public class RegisterationDActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;

    private Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration_d);

        b1=(Button)findViewById(R.id.br1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegisterationDActivity.this,RBirthActivity.class);
                startActivity(intent);
            }
        });

        b2=(Button)findViewById(R.id.br2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegisterationDActivity.this,RDeathActivity.class);
                startActivity(intent);
            }
        });


        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView=(NavigationView)findViewById(R.id.nview24);
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

        if(id==R.id.profiled)
        {
            Intent intent=new Intent(RegisterationDActivity.this,ProfileDActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.homed)
        {
            Intent intent=new Intent(RegisterationDActivity.this,DcHomeActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.notificationsd)
        {
            Intent intent=new Intent(RegisterationDActivity.this,NotificationsDActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.registerationd)
        {
            Intent intent=new Intent(RegisterationDActivity.this,RegisterationDActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.aboutd)
        {
            Intent intent=new Intent(RegisterationDActivity.this,AboutDActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.helpd)
        {
            Intent intent=new Intent(RegisterationDActivity.this,HelpDActivity.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
