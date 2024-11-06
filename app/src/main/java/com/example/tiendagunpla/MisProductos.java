package com.example.tiendagunpla;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MisProductos  extends RecyclerView.ViewHolder {

    ImageView pr;
    TextView mdl, nmb;

    public MisProductos(@NonNull View itemView) {
        super(itemView);
        pr = itemView.findViewById(R.id.fotoPerfil);
        mdl = itemView.findViewById(R.id.modelo);
        nmb = itemView.findViewById(R.id.nombre);

    }
}
