package com.example.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ImageView gambarTips;
    TextView judulArtikel, isiArtikel, isi;

    String judul2, deskripsi2, artikel2;
    int gambar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        gambarTips = findViewById(R.id.gambarTips);
        judulArtikel = findViewById(R.id.judulArtikel);
        isiArtikel = findViewById(R.id.isiArtikel);
        isi = findViewById(R.id.isi);

        getData();
        setData();
    }

    private  void getData(){
        if(getIntent().hasExtra("gambar2") && getIntent().hasExtra("judul2") &&
                getIntent().hasExtra("deskripsi2") && getIntent().hasExtra("artikel2")){
            judul2 = getIntent().getStringExtra("judul2");
            deskripsi2 = getIntent().getStringExtra("deskripsi2");
            artikel2 = getIntent().getStringExtra("artikel2");
            gambar2 = getIntent().getIntExtra("gambar2", 1);
        }else {
            Toast.makeText(this, "Tidak Ada Data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        judulArtikel.setText(judul2);
        isiArtikel.setText(deskripsi2);
        isi.setText(artikel2);
        gambarTips.setImageResource(gambar2);
    }
}
