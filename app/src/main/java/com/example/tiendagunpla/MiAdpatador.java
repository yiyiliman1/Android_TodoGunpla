package com.example.tiendagunpla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MiAdpatador extends RecyclerView.Adapter<MisProductos> {

    Context context;
    List<Item> items;

    public MiAdpatador(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MisProductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MisProductos(LayoutInflater.from(context).inflate(R.layout.productos,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MisProductos holder, int position) {
        holder.nameView.set
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
