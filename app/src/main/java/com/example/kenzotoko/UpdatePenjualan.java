package com.example.kenzotoko;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdatePenjualan extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1,ton2;
    EditText etext1, etext2, etext3, etext4, etext5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_penjualan);
        dbHelper = new DataHelper(this);
        etext1 = (EditText) findViewById(R.id.ed1);
        etext2 = (EditText) findViewById(R.id.ed2);
        etext3 = (EditText) findViewById(R.id.ed3);
        etext4 = (EditText) findViewById(R.id.ed4);
        etext5 = (EditText) findViewById(R.id.ed9);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM penjualan WHERE tgl_penjualan = '" +
                getIntent().getStringExtra("comot") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            etext1.setText(cursor.getString(0).toString());
            etext2.setText(cursor.getString(1).toString());
            etext3.setText(cursor.getString(2).toString());
            etext4.setText(cursor.getString(3).toString());
            etext5.setText(cursor.getString(4).toString());


        }
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        // daftarkan even onClick pada btnSimpan
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update penjualan set kd_penjualan='"+
                        etext1.getText().toString() +"', tgl_penjualan='" + etext2.getText().toString() +"', kd_pelanggan='" + etext3.getText().toString() +"', kd_barang='" + etext4.getText().toString() + "' where quantity='" + etext5.getText().toString()+"'");

                Toast.makeText(getApplicationContext(), "Berhasil",
                        Toast.LENGTH_LONG).show();
                ActivityPenjualan.ma.RefreshList();
                finish();
            }
        });
        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}