package com.nadim.assignment_teleaus.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nadim.assignment_teleaus.Api.Client;
import com.nadim.assignment_teleaus.Api.Service;
import com.nadim.assignment_teleaus.Controller.Fragments.BrowserFragment;
import com.nadim.assignment_teleaus.Controller.Fragments.DashboardFragment;
import com.nadim.assignment_teleaus.Controller.Fragments.HomeFragment;
import com.nadim.assignment_teleaus.Controller.Fragments.SettingsFragment;
import com.nadim.assignment_teleaus.Model.Data;
import com.nadim.assignment_teleaus.Model.MainModel;
import com.nadim.assignment_teleaus.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Data> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialise();
    }

    private void initialise() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.navigation_browser:
                    selectedFragment = new BrowserFragment();
                    break;
                case R.id.navigation_settings:
                    selectedFragment = new SettingsFragment();
                    break;
                case R.id.navigation_dashboard:
                    selectedFragment = new DashboardFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };


}