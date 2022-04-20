package com.android.mahasiswa;

import static androidx.core.os.LocaleListCompat.create;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.mahasiswa.MahasiswaActivity;

import java.sql.Struct;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;
    Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnClose = (Button) findViewById(R.id.btnClose);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();

                if (usernameKey.equals("Zaisul") && passwordKey.equals("191011402752")){
                    //Jika login berhasil
                    Toast.makeText(getApplicationContext(), "LOGIN SUKSES",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MahasiswaActivity.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                } else {
                    //JIka Login gagal
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Username atau Password Anda salah !!")
                            .setNegativeButton("Retry",null).create().show();
                }
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //menutup aplikasi
                finish();
            }
        });
    }
}