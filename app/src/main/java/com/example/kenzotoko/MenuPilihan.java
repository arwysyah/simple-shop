package com.example.kenzotoko;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPilihan extends AppCompatActivity {

    Button btnbarang,btnpelanggan,btnpenjualan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pilihan);
        btnbarang = (Button)findViewById((R.id.btn_barang));
        btnbarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuPilihan.this, ActivityBarang.class);
                startActivity(i);}
        });


        btnpelanggan = (Button)findViewById((R.id.btn_pelanggan));
        btnpelanggan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuPilihan.this, ActivityPelanggan.class);
                startActivity(i);}
        });

        btnpenjualan = (Button)findViewById((R.id.btn_penjualan));
        btnpenjualan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuPilihan.this, ActivityPenjualan.class);
                startActivity(i);}
        });

    }
}


