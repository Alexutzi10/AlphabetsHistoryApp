package com.example.istoriaalfabetelor;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.istoriaalfabetelor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationMenu();

        navigationView = findViewById(R.id.surugiu_george_alexandru_nav_view);
        navigationView.setNavigationItemSelectedListener(getItemSelectedListener());
    }

    private NavigationView.OnNavigationItemSelectedListener getItemSelectedListener() {
        return new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        };
    }

    private void navigationMenu() {
        Toolbar toolbar = findViewById(R.id.surugiu_george_alexandru_main_toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.surugiu_george_alexandru_main_drawer);
        ActionBarDrawerToggle actionBarToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        actionBarToggle.syncState();
    }
}