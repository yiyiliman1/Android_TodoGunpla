package com.example.tiendagunpla;

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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fg_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // logOut
        ImageView lOut = findViewById(R.id.logOut);

        lOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Inicio.class);
                startActivity(intent);
                finish(); // cierra la sesión actual
            }
        });

        // Te lleva a la ventana Opciones
        ImageView opciones = findViewById(R.id.opciones);

        opciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, opcionesVentana.class);
                startActivity(intent);
            }
        });

        // Te lleva al buscador
        TextView bsc = findViewById(R.id.buscador);

        bsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, buscador.class);
                startActivity(intent);
            }
        });

        // Te lleva a la ventana FG
        ImageView fgLogo = findViewById(R.id.fgLogo);

        fgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, fgVentana.class);
                startActivity(intent);
            }
        });

        // Te lleva a la ventana HG
        ImageView hgLogo = findViewById(R.id.hgLogo);

        hgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, hgVentana.class);
                startActivity(intent);
            }
        });

        // Te lleva a la ventana RG
        ImageView rgLogo = findViewById(R.id.rgLogo);

        rgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, rgVentana.class);
                startActivity(intent);
            }
        });

        // Te lleva a la ventana MG
        ImageView mgLogo = findViewById(R.id.mgLogo);

        mgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, mgVentana.class);
                startActivity(intent);
            }
        });

        // Te lleva a la ventana PG
        ImageView pgLogo = findViewById(R.id.pgLogo);

        pgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, pgVentana.class);
                startActivity(intent);
            }
        });
    }

}