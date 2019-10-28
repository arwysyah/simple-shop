package com.example.kenzotoko;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LihatPenjualan extends AppCompatActivity {
    protected Cursor cursor,cursor2,cursor3;
     int qty,harganya,ntext6;
    DataHelper dbHelper;
    Button ton1,ton2;
    EditText etext1, etext2, etext3,etext4, text12, etext5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_penjualan);
        dbHelper = new DataHelper(this);
        etext1 = (EditText) findViewById(R.id.ed1);
        etext2 = (EditText) findViewById(R.id.ed2);
        etext3 = (EditText) findViewById(R.id.ed3);
        etext5 = (EditText) findViewById(R.id.ed9);
        etext4 = (EditText) findViewById(R.id.ed4);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM penjualan WHERE kd_penjualan = '" +
                getIntent().getStringExtra("comot") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            etext1.setText(cursor.getString(0).toString());
            etext2.setText(cursor.getString(1).toString());
            etext3.setText(cursor.getString(2).toString());
            etext4.setText(cursor.getString(3).toString());
            etext5.setText(cursor.getString(4).toString());



        }
        {
            cursor2 = db.rawQuery("SELECT * FROM barang WHERE kd_barang = '" +
                    getIntent().getStringExtra("comot") + "'", null);
            cursor2.moveToFirst();
            if (cursor2.getCount() > 0) {
                cursor2.moveToPosition(0);
                text12.setText(cursor2.getString(5).toString());
                harganya = Integer.parseInt(cursor.getString(2).toString());


            }
        }

            ton1 = (Button) findViewById(R.id.button1);
            ton2 = (Button) findViewById(R.id.button2);
            ton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    finish();
                }
            });
        }
    }