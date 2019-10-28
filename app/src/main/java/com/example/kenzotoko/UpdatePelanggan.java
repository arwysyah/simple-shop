package com.example.kenzotoko;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class UpdatePelanggan extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText etext1, etext2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pelanggan);
        dbHelper = new DataHelper(this);
        etext1 = (EditText) findViewById(R.id.ed1);
        etext2 = (EditText) findViewById(R.id.ed2);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM pelanggan WHERE nama_pelanggan = '" +
                getIntent().getStringExtra("comot") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            etext1.setText(cursor.getString(0).toString());
            etext2.setText(cursor.getString(1).toString());

        } ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        // daftarkan even onClick pada btnSimpan
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update pelanggan set nama_pelanggan='"+ etext2.getText().toString() + "' where kd_pelanggan='" +
                        etext1.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil",
                        Toast.LENGTH_LONG).show();
                ActivityPelanggan.ma.RefreshList();
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