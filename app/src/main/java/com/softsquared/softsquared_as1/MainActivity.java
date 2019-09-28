package com.softsquared.softsquared_as1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Fragment_add fragment_add = new Fragment_add();
    private Fragment_heart fragment_heart = new Fragment_heart();
    private Fragment_home fragment_home = new Fragment_home();
    private Fragment_mypage fragment_mypage = new Fragment_mypage();
    private Frament_search fragment_search = new Frament_search();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* findViewById */
        bottomNavigationView = findViewById(R.id.navigationView);

        fragmentManager.beginTransaction().replace(R.id.framelayout, fragment_home).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.item_home:
                        fragmentManager.beginTransaction().replace(R.id.framelayout, fragment_home).commitAllowingStateLoss();
                        break;
                    case R.id.item_search:
                        fragmentManager.beginTransaction().replace(R.id.framelayout, fragment_search).commitAllowingStateLoss();
                        break;
                    case R.id.item_add:
                        fragmentManager.beginTransaction().replace(R.id.framelayout, fragment_add).commitAllowingStateLoss();
                        break;
                    case R.id.item_heart:
                        fragmentManager.beginTransaction().replace(R.id.framelayout, fragment_heart).commitAllowingStateLoss();
                        break;
                    case R.id.item_mypage:
                        fragmentManager.beginTransaction().replace(R.id.framelayout, fragment_mypage).commitAllowingStateLoss();
                        break;
                }
                return true;
            }
        });

    }
}

