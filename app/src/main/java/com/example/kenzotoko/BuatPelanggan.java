package com.example.kenzotoko;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class BuatPelanggan extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText etext1, etext2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_pelanggan);
        dbHelper = new DataHelper(this);
        etext1 = (EditText) findViewById(R.id.ed1);
        etext2 = (EditText) findViewById(R.id.ed2);

        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into pelanggan(kd_pelanggan, nama_pelanggan ) values('" +
                        etext1.getText().toString() + "','" +

                        etext2.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil",
                        Toast.LENGTH_LONG).show();
                ActivityPelanggan.ma.RefreshList();
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