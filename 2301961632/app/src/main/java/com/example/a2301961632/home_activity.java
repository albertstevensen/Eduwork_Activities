package com.example.a2301961632;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class home_activity extends AppCompatActivity {

    List<imageData> homeList;
    ListView lvHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lvHome = (ListView) findViewById(R.id.listviewHome);
        homeList = new ArrayList<>();

        homeList.add(new imageData(R.drawable.halsat_lake_scenery, "Halsat Lake Scenery", "halsat_lake_scenert.jpg"));
        homeList.add(new imageData(R.drawable.little_island_in_seas, "Little Island in Seas", "little_island_in_seas"));
        homeList.add(new imageData(R.drawable.sunset_scenery, "Sunset Scenery", "sunset_scenery.jpg"));

        customAdapter imageAdapter = new customAdapter(this, R.layout.row_homepage, homeList);
        lvHome.setAdapter(imageAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        if(item.getItemId() == R.id.signoutHome){
            intent = new Intent(this, loginActivity.class);
        } else if(item.getItemId() == R.id.manageMenu){
            intent = new Intent(this, manage_activity.class);
        }
        startActivity(intent);
        return true;
    }


}