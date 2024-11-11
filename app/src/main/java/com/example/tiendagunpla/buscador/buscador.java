package com.example.tiendagunpla.buscador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiendagunpla.inicio.MainActivity;
import com.example.tiendagunpla.R;

import java.util.ArrayList;
import java.util.List;

public class buscador extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buscador);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        RecyclerView recyvlerView = findViewById(R.id.lstPr);

        List<Productos> pr = new ArrayList<Productos>();
        pr.add(new Productos("FG",R.drawable.fg_gundam,"RX-78-2 Gundam"));
        pr.add(new Productos("FG",R.drawable.fg_exia,"GN-001 Gundam Exia"));
        pr.add(new Productos("FG",R.drawable.fg_kyrios,"GN-003 Gundam Kyrios"));
        pr.add(new Productos("FG",R.drawable.fg_dynames,"GN-002 Gundam Dynames"));
        pr.add(new Productos("FG",R.drawable.fg_virtue,"GN-005 Gundam Virtue"));
        pr.add(new Productos("HG",R.drawable.hg_gundam_original,"RX-78-2 Gundam"));
        pr.add(new Productos("HG",R.drawable.hg_strike_freedom,"Perfect Strike Freedom Rouge Gundam"));
        pr.add(new Productos("HG",R.drawable.hg_oo,"GN-0000 00 Gundam"));
        pr.add(new Productos("RG",R.drawable.rgexia,"GN-001 Gundam Exia"));
        pr.add(new Productos("RG",R.drawable.rg_freedom,"ZGMF-X10A Freedom Gundam"));
        pr.add(new Productos("RG",R.drawable.rgdestiny,"ZGMF-X42S Destiny Gundam"));
        pr.add(new Productos("RG",R.drawable.rgimpul,"ZGMF-X56S Impulse Gundam"));
        pr.add(new Productos("MG",R.drawable.mg_barbatos,"ASW-G-08 Gundam Barbatos"));
        pr.add(new Productos("MG",R.drawable.mg_buster,"GAT-X103 Buster Gundam"));
        pr.add(new Productos("MG",R.drawable.mg_freedom,"ZGMF-X10A Freedom Gundam"));
        pr.add(new Productos("PG",R.drawable.pg_freedom,"ZGMF-X20A Strike Freedom Gundam"));
        pr.add(new Productos("PG",R.drawable.pg_exia,"GN-001 Gundam Exia"));

        recyvlerView.setLayoutManager(new LinearLayoutManager(this));
        recyvlerView.setAdapter(new MiAdaptador(getApplicationContext(),pr));

        // Buscador de productos
        MiAdaptador miAdaptador = new MiAdaptador(this, pr);
        recyvlerView.setAdapter(miAdaptador);

        SearchView searchView = findViewById(R.id.sV);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<Productos> listaFiltrada = new ArrayList<>();
                for (Productos producto : pr) {
                    if (producto.getNombre().toLowerCase().contains(newText.toLowerCase()) ||
                            producto.getModelo().toLowerCase().contains(newText.toLowerCase())) {
                        listaFiltrada.add(producto);
                    }
                }
                miAdaptador.filtrarLista(listaFiltrada);
                return true;
            }
        });
    }
}