package com.example.tiendagunpla.modelos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tiendagunpla.R;
import com.example.tiendagunpla.buscador.buscador;
import com.example.tiendagunpla.buscador.detalle_producto;
import com.example.tiendagunpla.inicio.MainActivity;

public class fgVentana extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fg_ventana);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fg_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Te lleva al buscador
        TextView bsc = findViewById(R.id.buscador);

        bsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fgVentana.this, buscador.class);
                startActivity(intent);
            }
        });

        ImageView paginaHome = findViewById(R.id.paginaHome);

        paginaHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fgVentana.this, MainActivity.class);
                startActivity(intent);
            }
        });


        // para cada producto
        ImageView fgGundam = findViewById(R.id.fg_gundam);
        ImageView fgExia = findViewById(R.id.fg_exia);
        ImageView fgDynames = findViewById(R.id.fg_dynames);
        ImageView fgKyrios = findViewById(R.id.fg_kyrios);
        ImageView fgVirtue = findViewById(R.id.fg_virtue);

        fgGundam.setOnClickListener(v -> abrirDetalles("fg_gundam"));
        fgExia.setOnClickListener(v -> abrirDetalles("fg_exia"));
        fgDynames.setOnClickListener(v -> abrirDetalles("fg_dynames"));
        fgKyrios.setOnClickListener(v -> abrirDetalles("fg_kyrios"));
        fgVirtue.setOnClickListener(v -> abrirDetalles("fg_virtue"));
    }

    private void abrirDetalles(String productoId) {
        Intent intent = new Intent(this, detalle_producto.class);
        intent.putExtra("producto_id", productoId);
        startActivity(intent);
    }
}


