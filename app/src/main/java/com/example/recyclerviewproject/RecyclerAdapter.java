package com.example.recyclerviewproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.LayoutInflaterCompat;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    String judul2[], teras2[], deskripsi2[], artikel2[];
    int gambar[];
    Context context;

    public RecyclerAdapter(Context ct,
                           String[] judul, String[] teras, String[] deskripsi, String[] artkl,
                           int gmbr[]) {
        context = ct;
        judul2 = judul;
        teras2 = teras;
        deskripsi2 = deskripsi;
        artikel2 = artkl;
        gambar = gmbr;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_awal, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.judulTips.setText(judul2[position]);
        holder.terasTips.setText(teras2[position]);
        holder.gambarTips.setImageResource(gambar[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("judul2", judul2[position]);
                intent.putExtra("deskripsi2", deskripsi2[position]);
                intent.putExtra("gambar2", gambar[position]);
                intent.putExtra("artikel2", artikel2[position]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() { return gambar.length; }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView judulTips, terasTips;
        ImageView gambarTips;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            judulTips = itemView.findViewById(R.id.judulTips);
            terasTips = itemView.findViewById(R.id.terasTips);
            gambarTips = itemView.findViewById(R.id.gambarUtama);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}