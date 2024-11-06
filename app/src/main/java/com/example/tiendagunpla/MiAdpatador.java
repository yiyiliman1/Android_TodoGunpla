package com.example.tiendagunpla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdpatador extends RecyclerView.Adapter<MisProductos> {

    Context context;
    List<Productos> pr;

    public MiAdpatador(Context context, List<Productos> pr) {
        this.context = context;
        this.pr = pr;
    }

    @NonNull
    @Override
    public MisProductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MisProductos(LayoutInflater.from(context).inflate(R.layout.productos,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MisProductos holder, int position) {
        holder.pr.setImageResource(pr.get(position).getImg());
        holder.mdl.setText(pr.get(position).getModelo());
        holder.nmb.setText(pr.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return pr.size();
    }

    public void filtrarLista(List<Productos> listaFiltrada) {
        this.pr = listaFiltrada;
        notifyDataSetChanged();
    }
}
