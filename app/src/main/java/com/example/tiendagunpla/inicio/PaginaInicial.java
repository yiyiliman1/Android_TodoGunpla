package com.example.tiendagunpla.inicio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tiendagunpla.Montar.MontarInicio;
import com.example.tiendagunpla.Pintar.PintarInicio;
import com.example.tiendagunpla.R;
import com.example.tiendagunpla.buscador.buscador;

public class PaginaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pagina_inicial);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // logOut
        ImageView lOut = findViewById(R.id.paginaHome);

        lOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaginaInicial.this, Inicio.class);
                startActivity(intent);
                finish(); // cierra la sesión actual
            }
        });
        // Te lleva al buscador
        TextView bsc = findViewById(R.id.buscador);

        bsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaginaInicial.this, buscador.class);
                startActivity(intent);
            }
        });

        FrameLayout tienda = findViewById(R.id.IMG_tienda);

        tienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaginaInicial.this, MainActivity.class);
                startActivity(intent);
            }
        });

        FrameLayout montar = findViewById(R.id.IMG_montar);

        montar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaginaInicial.this, MontarInicio.class);
                startActivity(intent);
            }
        });

        FrameLayout pintar = findViewById(R.id.IMG_pintar);

        pintar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaginaInicial.this, PintarInicio.class);
                startActivity(intent);
            }
        });

        ImageView ToInst = findViewById(R.id.Insta);
        ToInst.setOnClickListener(v -> {
            String url = "https://www.instagram.com/gundamstagram/?hl=es";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        ImageView ToTw = findViewById(R.id.Tw);
        ToTw.setOnClickListener(v -> {
            String url = "https://x.com/GundamSpain";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        ImageView ToYT = findViewById(R.id.YT);
        ToYT.setOnClickListener(v -> {
            String url = "https://www.youtube.com/@MiniFLY/videos";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        TextView ToPri = findViewById(R.id.Pri);
        ToPri.setOnClickListener(v -> {
            String url = "https://policies.google.com/privacy?hl=es";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
    }

}