package com.example.istoriaalfabetelor;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.istoriaalfabetelor.fragments.AboutFragment;
import com.example.istoriaalfabetelor.fragments.AlphabetsFragment;
import com.example.istoriaalfabetelor.fragments.HomeFragment;
import com.example.istoriaalfabetelor.fragments.NumberConverterFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private FloatingActionButton triviaFab;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationMenu();

        navigationView = findViewById(R.id.surugiu_george_alexandru_nav_view);
        navigationView.setNavigationItemSelectedListener(getItemSelectedListener());
        triviaFab = findViewById(R.id.surugiu_george_alexandru_triviaFab);

        triviaFab.setOnClickListener(click -> {
            Intent triviaWindow = new Intent(getApplicationContext(), TakeTriviaActivity.class);
            startActivity(triviaWindow);
        });
    }

    private NavigationView.OnNavigationItemSelectedListener getItemSelectedListener() {
        return item -> {
            if (item.getItemId() == R.id.nav_home) {
                currentFragment = new HomeFragment();
            } else if (item.getItemId() == R.id.nav_learn) {
                currentFragment = new AlphabetsFragment();
            } else if (item.getItemId() == R.id.nav_numbers) {
                currentFragment = new NumberConverterFragment();
            } else if (item.getItemId() == R.id.nav_about){
                currentFragment = new AboutFragment();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            openFragment();
            return true;
        };
    }

    private void openFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.surugiu_george_alexandru_fl_containter, currentFragment).commit();
    }

    private void navigationMenu() {
        Toolbar toolbar = findViewById(R.id.surugiu_george_alexandru_main_toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.surugiu_george_alexandru_main_drawer);
        ActionBarDrawerToggle actionBarToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        actionBarToggle.syncState();
    }
}