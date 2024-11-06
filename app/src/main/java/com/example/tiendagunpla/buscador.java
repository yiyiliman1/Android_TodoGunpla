package com.example.tiendagunpla;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

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

        // logOut
        ImageView hM = findViewById(R.id.homeMain);

        hM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(buscador.this, MainActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView recyvlerView = findViewById(R.id.lstPr);

        List<Productos> pr = new ArrayList<Productos>();
        pr.add(new Productos("RG",R.drawable.rg_freedom,"Freedom"));
        pr.add(new Productos("RG",R.drawable.rgdestiny,"Destiny"));
        pr.add(new Productos("MG",R.drawable.mg_barbatos,"Barbatos"));

        recyvlerView.setLayoutManager(new LinearLayoutManager(this));
        recyvlerView.setAdapter(new MiAdpatador(getApplicationContext(),pr));

        // Buscador de productos
        MiAdpatador miAdaptador = new MiAdpatador(this, pr);
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