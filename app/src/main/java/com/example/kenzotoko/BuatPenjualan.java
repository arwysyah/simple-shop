package com.example.kenzotoko;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class BuatPenjualan extends AppCompatActivity {



        protected Cursor cursor;
        DataHelper dbHelper;
        Button ton1, ton2;
        EditText etext1, etext2, etext3, etext4, etext5;
        @Override protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_buat_penjualan);
            dbHelper = new DataHelper(this);
            etext1 = (EditText) findViewById(R.id.ed1);
            etext2 = (EditText) findViewById(R.id.ed2);
            etext3 = (EditText) findViewById(R.id.ed3);
            etext4 = (EditText) findViewById(R.id.ed4);
            etext5 = (EditText) findViewById(R.id.ed9);
            ton1 = (Button) findViewById(R.id.button1);
            ton2 = (Button) findViewById(R.id.button2);
            ton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL("insert into penjualan(kd_penjualan, tgl_penjualan, kd_pelanggan, kd_barang,quantity) values('" +
                            etext1.getText().toString() + "','" +
                            etext2.getText().toString() + "','" +
                            etext3.getText().toString() + "','" +
                            etext4.getText().toString() + "','" +
                            etext5.getText().toString() + "')");
                    Toast.makeText(getApplicationContext(), "Berhasil",
                            Toast.LENGTH_LONG).show();
                    ActivityPenjualan.ma.RefreshList();
                    finish();
                }
            });
            ton2.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    finish();
                }
            });

        }
    }
