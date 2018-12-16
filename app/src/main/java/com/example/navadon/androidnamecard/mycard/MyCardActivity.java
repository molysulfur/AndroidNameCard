package com.example.navadon.androidnamecard.mycard;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.navadon.androidnamecard.R;

public class MyCardActivity extends AppCompatActivity {
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbarMycard;
    private DrawerLayout drawerLayout;
    private Button btnMyCard;
    private Button btnListCard;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycard);
        setHumburgerButton();
        initInstances(savedInstanceState);
    }

    private void setHumburgerButton() {
        toolbarMycard = findViewById(R.id.toolbar_mycard);
        drawerLayout = findViewById(R.id.drawerLayout);
        setSupportActionBar(toolbarMycard);

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                MyCardActivity.this,
                drawerLayout,
                R.string.string_openmenu,
                R.string.string_closemenu);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initInstances(Bundle savedInstanceState) {
        btnMyCard = findViewById(R.id.btn_mycard);
        btnListCard = findViewById(R.id.btn_listcard);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_activity,MyCardFragment.newInstance(getIntent().getStringExtra("userId")))
                    .commit();
        }
        onClickEvent();
    }

    private void onClickEvent() {
        btnMyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_activity,MyCardFragment.newInstance(getIntent().getStringExtra("userId")))
                        .commit();
            }
        });

        btnListCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_activity,ListCardFragment.newInstance(getIntent().getStringExtra("userId")))
                        .commit();
            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
}
