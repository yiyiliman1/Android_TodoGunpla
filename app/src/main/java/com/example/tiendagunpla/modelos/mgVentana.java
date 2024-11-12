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
import com.example.tiendagunpla.detalle_producto;
import com.example.tiendagunpla.inicio.MainActivity;
import com.example.tiendagunpla.opcionesVentana;

public class mgVentana extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mg_ventana);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Te lleva al buscador
        TextView bsc = findViewById(R.id.buscador);

        bsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mgVentana.this, buscador.class);
                startActivity(intent);
            }
        });

        ImageView paginaHome = findViewById(R.id.paginaHome);

        paginaHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mgVentana.this, MainActivity.class);
                startActivity(intent);
            }
        });


        ImageView opciones = findViewById(R.id.opciones);

        opciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mgVentana.this, opcionesVentana.class);
                startActivity(intent);
            }
        });
        // para cada producto
        ImageView mg_freedom = findViewById(R.id.mg_freedom);
        ImageView mg_buster = findViewById(R.id.mg_buster);
        ImageView mg_barbatos = findViewById(R.id.mg_barbatos);

        mg_freedom.setOnClickListener(v -> abrirDetalles("mg_freedom"));
        mg_buster.setOnClickListener(v -> abrirDetalles("mg_buster"));
        mg_barbatos.setOnClickListener(v -> abrirDetalles("mg_barbatos"));
    }

    private void abrirDetalles(String productoId) {
        Intent intent = new Intent(this, detalle_producto.class);
        intent.putExtra("producto_id", productoId);
        startActivity(intent);
    }
}