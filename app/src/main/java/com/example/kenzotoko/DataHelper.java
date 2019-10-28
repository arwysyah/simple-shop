package com.example.kenzotoko;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "toko5.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
    @Override public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS barang");
        db.execSQL("CREATE TABLE IF NOT EXISTS barang(kd_barang integer primary key autoincrement,  nama_barang text, harga_barang integer)");
        db.execSQL("INSERT INTO barang ( kd_barang, nama_barang, harga_barang) VALUES ('11207','Sweater','2000000')");
        db.execSQL("INSERT INTO barang (kd_barang, nama_barang, harga_barang) VALUES ('11221', 'Tshirt','5000000')");
        db.execSQL("INSERT INTO barang (kd_barang, nama_barang, harga_barang) VALUES ('112431', 'Jeans','1000000')");
        db.execSQL("INSERT INTO barang (kd_barang, nama_barang, harga_barang) VALUES ('11212', 'shoes','6000000')");

        db.execSQL("DROP TABLE IF EXISTS pelanggan");
        db.execSQL("CREATE TABLE IF NOT EXISTS pelanggan(kd_pelanggan integer primary key autoincrement, nama_pelanggan text)");
        db.execSQL("INSERT INTO pelanggan (kd_pelanggan, nama_pelanggan) VALUES ('1021', 'Arwy Syahputra Siregar')");
        db.execSQL("INSERT INTO pelanggan (kd_pelanggan, nama_pelanggan) VALUES ('1022', 'Kenzoymc')");

        db.execSQL("DROP TABLE IF EXISTS penjualan");
        db.execSQL("CREATE TABLE IF NOT EXISTS penjualan(kd_penjualan integer primary key autoincrement, tgl_penjualan text, kd_pelanggan integer, kd_barang integer,quantity integer)");
        db.execSQL("INSERT INTO penjualan (kd_penjualan, tgl_penjualan, kd_pelanggan, kd_barang, quantity) VALUES ('101', '20-12-2018','1021','11207','3')");
        db.execSQL("INSERT INTO penjualan (kd_penjualan, tgl_penjualan, kd_pelanggan, kd_barang, quantity) VALUES ('102', '20-03-2019', '1022','11221','6')");


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS barang");
        db.execSQL("DROP TABLE IF EXISTS pelanggan");
        db.execSQL("DROP TABLE IF EXISTS penjualan");
        onCreate(db);
    }
}
