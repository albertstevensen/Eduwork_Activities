package com.example.a2301961632;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Random;

public class register_activity extends AppCompatActivity {

    EditText nama, email, password, alamat, nomorTelepon;
    RadioGroup chooseGender;
    Button registerButton, dateofbirthButton;
    CheckBox registerCheck;

    int max = 999;
    int min = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nama = findViewById(R.id.registerName);
        email = findViewById(R.id.registerEmail);
        password = findViewById(R.id.registerPassword);
        alamat = findViewById(R.id.registerAddress);
        nomorTelepon = findViewById(R.id.registerPhone);
        chooseGender = findViewById(R.id.radioGroup);
        registerCheck = findViewById(R.id.registerCheck);
        registerButton = findViewById(R.id.regButton);
        datePicker();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validasiNama()  ||
                        !validasiEmail()    ||
                        !validasiPassword() ||
                        !validasiGender()   ||
                        !validasiAlamat()   ||
                        !validasiAlamat()   ||
                        !validasiNomor()    ||
                        !validasiCheck()){
                    return;
                } else{
                    loginActivity();
                }
            }
        });
    }

    private boolean validasiNama() {
        String registerNama = nama.getText().toString().trim();

        if (registerNama.isEmpty()) {
            Toast.makeText(register_activity.this, "Please insert your name", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!(registerNama.length() > 4)) {
            Toast.makeText(register_activity.this, "Name must bew longer than 4 character", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
    private boolean validasiEmail() {
        String registerEmail = email.getText().toString().trim();

        if (Patterns.EMAIL_ADDRESS.matcher(registerEmail).matches()) {
            return true;
        } else if (registerEmail.isEmpty()){
            Toast.makeText(register_activity.this, "Please insert your email", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!registerEmail.contains("@")) {
            Toast.makeText(register_activity.this, "Email must contain @", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!registerEmail.contains(".")) {
            Toast.makeText(register_activity.this, "Email must contain .", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            Toast.makeText(register_activity.this, "@ must not be adjacent to .", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    private boolean validasiPassword() {
        String kataSandi = password.getText().toString().trim();

        if (kataSandi.isEmpty()) {
            Toast.makeText(register_activity.this, "Please insert your password", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!(kataSandi.length() > 4)) {
            Toast.makeText(register_activity.this, "Password must be longer than 4 character", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
    private boolean validasiGender() {
        if (chooseGender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(register_activity.this, "Please select gender", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
    private boolean validasiAlamat() {
        String registerAlamat = alamat.getText().toString();

        if (registerAlamat.isEmpty()) {
            Toast.makeText(register_activity.this, "Please insert your address", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!(registerAlamat.length() > 8)) {
            Toast.makeText(register_activity.this, "Address must be longer than 8 character", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!registerAlamat.endsWith("street")) {
            Toast.makeText(register_activity.this, "Address must end with street", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
    private boolean validasiNomor() {
        String tlp = nomorTelepon.getText().toString().trim();

        if (tlp.isEmpty()) {
            Toast.makeText(register_activity.this, "Please insert your phone number", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
    private boolean validasiCheck() {
        if (!registerCheck.isChecked()) {
            Toast.makeText(register_activity.this, "Please check our terms and condition", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
    private void loginActivity() {
        int randomNumber = new Random().nextInt((max - min) + 1) + min;

        AlertDialog.Builder builder = new AlertDialog.Builder(register_activity.this);
        builder.setTitle("Account Registered").setMessage("US" + String.valueOf(randomNumber)).
                setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("action", "login");

                        String registeredEmail = email.getText().toString();
                        String registeredPassword = password.getText().toString();

                        Intent intent = new Intent(register_activity.this, loginActivity.class);

                        intent.putExtra("registeredEmail", registeredEmail);
                        intent.putExtra("registeredPassword", registeredPassword);

                        startActivity(intent);
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void datePicker(){
        dateofbirthButton = findViewById(R.id.registerDate);
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                dateofbirthButton.setText(day + "/" + month + "/" + year);
            }
        };
        dateofbirthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar kalender = Calendar.getInstance();
                int day = kalender.get(Calendar.DAY_OF_MONTH);
                int month = kalender.get(Calendar.MONTH);
                int year = kalender.get(Calendar.YEAR);

                DatePickerDialog dialog = new DatePickerDialog(register_activity.this, listener, year, month, day);
                dialog.show();
            }
        });
    }
}