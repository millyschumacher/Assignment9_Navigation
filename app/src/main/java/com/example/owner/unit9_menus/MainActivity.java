package com.example.owner.unit9_menus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

//This class displays the implementation of the first screen of the app
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Send Your Study Buddy An Email", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hi Study Buddy");
                if(emailIntent.resolveActivity(getPackageManager())!=null){
                    startActivity(emailIntent);
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
            return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //These else-if statements go through each of the menu options and display a message,
        //as the functionality for all of of the menu options is not yet available.
        if (id == R.id.nav_add) {
            Snackbar.make(getWindow().getDecorView(), "Adding study mates is not currently available.",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return true;

        } else if (id == R.id.nav_delete) {
            Snackbar.make(getWindow().getDecorView(), "Deleting study mates is not currently available.",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return true;

        } else if (id == R.id.nav_email) {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            //send this to my school email
            emailIntent.setData(Uri.parse("mailto: aschumacher@css.edu"));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hey Study Buddy");
            if (emailIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(emailIntent);
            }

        } else if (id == R.id.nav_settings) {
            Intent settingsIntent = ( new Intent(this, SettingsActivity.class));
            startActivity(settingsIntent);
            return true;

        } else if (id == R.id.nav_sms) {
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
            //my phone number
            smsIntent.setData(Uri.parse("smsto: 6513574852"));
            smsIntent.putExtra("sms_body", "Hello Study Buddy");
            if (smsIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(smsIntent);
            }
            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}