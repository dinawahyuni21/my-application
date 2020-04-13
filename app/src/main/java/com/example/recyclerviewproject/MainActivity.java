package com.example.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String judul[], deskripsi[];
    String artikel[], teras[];
    int gambar[] = {R.drawable.a_cucitangan,R.drawable.a_imun,R.drawable.a_olahraga,
            R.drawable.a_makanan,R.drawable.a_diet,R.drawable.a_dbd,R.drawable.a_corona};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        judul = getResources().getStringArray(R.array.info_kesehatan);
        teras = getResources().getStringArray(R.array.teras_judul);
        deskripsi = getResources().getStringArray(R.array.deskripsi);
        artikel = getResources().getStringArray(R.array.isi);

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter
                (this, judul, teras, deskripsi, artikel, gambar);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

