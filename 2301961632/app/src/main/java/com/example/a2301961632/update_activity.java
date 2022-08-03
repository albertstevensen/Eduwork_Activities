package com.example.a2301961632;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class update_activity extends AppCompatActivity {

    Button saveButton;
    EditText updateTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        saveButton = findViewById(R.id.saveBtn);
        updateTitle = findViewById(R.id.updateTitle);

        Intent intent = getIntent();
        String imageTitle = updateTitle.getText().toString().trim();
        String update = intent.getStringExtra("title");
        updateTitle.setText(update);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                String imageTitle = updateTitle.getText().toString().trim();
                String update = intent.getStringExtra("title");

                if(imageTitle.isEmpty()){
                    Toast.makeText(update_activity.this, "Please rename image title", Toast.LENGTH_SHORT).show();
                } else if (imageTitle.equals(update)) {
                    Toast.makeText(update_activity.this, "Insert new name", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(update_activity.this, "Image title saved", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(update_activity.this, home_activity.class);
                    String save = updateTitle.getText().toString();
                    intent.putExtra("title", save);
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        if(item.getItemId() == R.id.editHome){
            intent = new Intent(this, home_activity.class);
        } else if (item.getItemId() == R.id.editManage){
            intent = new Intent(this, manage_activity.class);
        } else if (item.getItemId() == R.id.editSignout){
            intent = new Intent(this, loginActivity.class);
        }
        startActivity(intent);
        return true;
    }
}