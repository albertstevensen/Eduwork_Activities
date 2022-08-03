package com.example.a2301961632;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    TextView regisButton;
    EditText lEmail, lPassword;
    Button logButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        lEmail = findViewById(R.id.loginEmail);
        lPassword = findViewById(R.id.loginPassword);
        logButton = findViewById(R.id.loginButton);
        regisButton = findViewById(R.id.registerButton);

        regisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerActivity();
            }
        });

        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validasiEmail() || !validasiPassword()){
                    return;
                } else {
                    homeActivity();
                }
            }
        });
    }

    private boolean validasiEmail(){
        Intent intent =getIntent();
        String loginEmail = lEmail.getText().toString().trim();
        String inputEmail =intent.getStringExtra("registeredEmail");

        if (loginEmail.isEmpty()){
            Toast.makeText(loginActivity.this, "Please input your email", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!loginEmail.equals(inputEmail)){
            Toast.makeText(loginActivity.this, "Email not registered yet", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
    private boolean validasiPassword(){
        Intent intent = getIntent();
        String loginPassword =lPassword.getText().toString().trim();
        String inputPassword = intent.getStringExtra("registeredPassword");

        if (loginPassword.isEmpty()){
            Toast.makeText(loginActivity.this, "Please input your password", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!loginPassword.equals(inputPassword)){
            Toast.makeText(loginActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
    private void homeActivity(){
        Toast.makeText(loginActivity.this, "Login success", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(loginActivity.this, home_activity.class);
        startActivity(intent);
    }
    private void registerActivity(){
        Intent intent = new Intent(loginActivity.this, register_activity.class);
        startActivity(intent);
    }

}

