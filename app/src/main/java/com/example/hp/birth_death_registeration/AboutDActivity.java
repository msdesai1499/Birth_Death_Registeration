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

public class AboutDActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_d);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView=(NavigationView)findViewById(R.id.nview25);
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
            Intent intent=new Intent(AboutDActivity.this,ProfileDActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.homed)
        {
            Intent intent=new Intent(AboutDActivity.this,DcHomeActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.notificationsd)
        {
            Intent intent=new Intent(AboutDActivity.this,NotificationsDActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.registerationd)
        {
            Intent intent=new Intent(AboutDActivity.this,RegisterationDActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.aboutd)
        {
            Intent intent=new Intent(AboutDActivity.this,AboutDActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.helpd)
        {
            Intent intent=new Intent(AboutDActivity.this,HelpDActivity.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

