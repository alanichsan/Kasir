package com.example.kasir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class KasirActivity extends AppCompatActivity {
     EditText edtnamapel, edtnamabar, edtjumlahbel, edtharga, edtuangbay;
     Button btnproses;
     Button btnhapus;
     Button btnexit;
     TextView txtnamapel;
     TextView txtnamabar;
     TextView txtjumlahbel;
     TextView txtharga;
     TextView txtuangbay;
     TextView txtbonus;
     TextView txttotalbelanja;
     TextView txtuangkembali;
     TextView txtketerangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kasir);
//        getSupportActionBar().setTitle("ShopBack");

        edtnamapel = (EditText) findViewById(R.id.namapelanggan);
        edtnamabar = (EditText) findViewById(R.id.namabarang);
        edtjumlahbel = (EditText) findViewById(R.id.jumlahbeli);
        edtharga = (EditText) findViewById(R.id.harga);
        edtuangbay = (EditText) findViewById(R.id.uangbayar);
        btnproses = (Button) findViewById(R.id.tombol1);
        btnhapus = (Button) findViewById(R.id.tombol2);
        btnexit = (Button) findViewById(R.id.tombol3);
        txtnamapel = (TextView) findViewById(R.id.namapelanggan);
        txtnamabar = (TextView) findViewById(R.id.namabarang);
        txtjumlahbel = (TextView) findViewById(R.id.jumlahbeli);
        txtharga = (TextView) findViewById(R.id.harga);
        txtuangbay = (TextView) findViewById(R.id.uangbayar);
        txtbonus = (TextView) findViewById(R.id.bonus);
        txttotalbelanja = (TextView) findViewById(R.id.totalbelanja);
        txtuangkembali = (TextView) findViewById(R.id.uangkembali);
        txtketerangan = (TextView) findViewById(R.id.keterangan);


        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namapelanggan = edtnamapel.getText().toString();
                String namabarang = edtnamabar.getText().toString();
                String jumlahbeli = edtjumlahbel.getText().toString();
                String harga = edtharga.getText().toString();
                String uangbayar = edtuangbay.getText().toString();

                double jb = Double.parseDouble(jumlahbeli);
                double h = Double.parseDouble (harga);
                double ub = Double.parseDouble (uangbayar);
                double total = (jb * h);

                txttotalbelanja.setText("Total Belanja : " + total);
                if (namapelanggan.isEmpty() && namabarang.isEmpty() && jumlahbeli.isEmpty() && harga.isEmpty() && uangbayar.isEmpty()){
                    Toast.makeText(getApplicationContext(),"ISI SEMUA", Toast.LENGTH_LONG).show();
                }

                if (total >=200000){
                    txtbonus.setText("Bonus : Mouse");
                } else if (total >=50000){
                    txtbonus.setText("Bonus : Keyboard");
                } else  if (total >=40000){
                    txtbonus.setText("Bonus : Harddisk");
                } else {
                    txtbonus.setText("Bonus : Tidak Ada Bonus");
                }
                double uangkembalian = (ub - total);

                if (ub < total){
                    txtketerangan.setText("Keterangan : uang bayar kurang Rp " + (-uangkembalian));
                    txtuangkembali.setText("Uang Kembali : Rp 0" );
                }else{
                    txtketerangan.setText("Keterangan : Tunggu Kembalian");
                    txtuangkembali.setText("Uang Kembali : " + uangkembalian);
                }
            }
        });

        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtnamapel.setText(" ");
                txtnamabar.setText(" ");
                txttotalbelanja.setText(" Total Belanja : Rp 0");
                txtharga.setText(" ");
                txtuangbay.setText(" ");
                txtuangkembali.setText("Uang Kembali : Rp 0");
                txtbonus.setText("Bonus : - ");
                txtjumlahbel.setText(" ");
                txtketerangan.setText("Keterangan : - ");

                Toast.makeText(getApplicationContext(),"Data sudah direset", Toast.LENGTH_LONG).show();


            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                moveTaskToBack(true);
            }
        });

    }

}
