package com.example.kenzotoko;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LihatBarang extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton2;
    EditText etext1, etext2, etext3, etext4, etext5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_barang);
        dbHelper = new DataHelper(this);
        etext1 = (EditText) findViewById(R.id.ed2);
        etext2 = (EditText) findViewById(R.id.ed3);
        etext3 = (EditText) findViewById(R.id.ed4);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM barang WHERE nama_barang = '" +
                getIntent().getStringExtra("comot") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            etext1.setText(cursor.getString(0).toString());
            etext2.setText(cursor.getString(1).toString());
            etext3.setText(cursor.getString(2).toString());

        } ton2 = (Button) findViewById(R.id.button1);
        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}