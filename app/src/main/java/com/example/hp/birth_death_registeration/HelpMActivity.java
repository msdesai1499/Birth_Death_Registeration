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

public class HelpMActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_m);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView=(NavigationView)findViewById(R.id.nview36);
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

        if(id==R.id.profilem)
        {
            Intent intent=new Intent(HelpMActivity.this,ProfileMActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.homem)
        {
            Intent intent=new Intent(HelpMActivity.this,MoHomeActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.notificationsm)
        {
            Intent intent=new Intent(HelpMActivity.this,NotificationMActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.aboutm)
        {
            Intent intent=new Intent(HelpMActivity.this,AboutMActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.helpm)
        {
            Intent intent=new Intent(HelpMActivity.this,HelpMActivity.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
