package com.example.kenzotoko;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LihatPelanggan extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton2;
    EditText etext1, etext2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_pelanggan);
        dbHelper = new DataHelper(this);
        etext1 = (EditText) findViewById(R.id.ed2);

        etext2 = (EditText) findViewById(R.id.ed3);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM pelanggan WHERE nama_pelanggan = '" +
                getIntent().getStringExtra("comot") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            etext1.setText(cursor.getString(0).toString());
            etext2.setText(cursor.getString(1).toString());

        }
        ton2 = (Button) findViewById(R.id.button1);
        ton2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}