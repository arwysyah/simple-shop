package com.example.kenzotoko;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        Button btnLogin;
        EditText etUser;
        EditText etPass;
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            etUser = (EditText) findViewById(R.id.in_username);
            etPass = (EditText) findViewById(R.id.in_password);
            btnLogin = (Button) findViewById(R.id.btn_login);
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (etUser.getText().toString().equals("kenzo")&&
                            etPass.getText().toString().equals("kenzo123")){
                        Toast.makeText(getApplicationContext(),"Berhasil Login",Toast.LENGTH_LONG).show();
                        Intent i = new Intent (MainActivity.this, MenuPilihan.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(),"Anda Pencuri",Toast.LENGTH_LONG).show();

                    }
                }
            });
        }
    }

