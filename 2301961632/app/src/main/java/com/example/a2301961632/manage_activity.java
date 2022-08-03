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

public class manage_activity extends AppCompatActivity {

    List<imagesManage> manageImages;
    ListView lvmanage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        lvmanage = (ListView) findViewById(R.id.listviewManage);
        manageImages = new ArrayList<>();

        manageImages.add(new imagesManage(R.drawable.halsat_lake_scenery, "Halsat Lake Scenery", "halsat_lake_scenery"));
        manageImages.add(new imagesManage(R.drawable.sunset_scenery, "Sunset Scenery", "sunset_scnery.jpg"));
        manageImages.add(new imagesManage(R.drawable.little_island_in_seas, "Little Island in Seas", "little_island_in_seas.jpg"));

        manageAdapter manageadapter = new manageAdapter(this, R.layout.row_manage, manageImages);
        lvmanage.setAdapter(manageadapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manage_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        if(item.getItemId() == R.id.homeManage){
            intent = new Intent(this, home_activity.class);
        } else if (item.getItemId() == R.id.signoutManage){
            intent = new Intent(this, loginActivity.class);
        }
        startActivity(intent);
        return true;
    }
}