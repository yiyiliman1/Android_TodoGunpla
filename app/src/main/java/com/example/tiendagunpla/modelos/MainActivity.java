package com.example.tiendagunpla.modelos;

import android.content.Intent;
import android.net.Uri;
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
import com.example.tiendagunpla.inicio.PaginaInicial;

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
        ImageView lOut = findViewById(R.id.paginaHome);

        lOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PaginaInicial.class);
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
        ImageView rgLogo = findViewById(R.id.IMG_montar);

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