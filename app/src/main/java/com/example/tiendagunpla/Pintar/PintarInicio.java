package com.example.tiendagunpla.Pintar;

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

import com.example.tiendagunpla.Montar.Avanzado;
import com.example.tiendagunpla.Montar.Intermedio;
import com.example.tiendagunpla.Montar.MontarInicio;
import com.example.tiendagunpla.Montar.Principiante;
import com.example.tiendagunpla.R;
import com.example.tiendagunpla.buscador.buscador;
import com.example.tiendagunpla.inicio.PaginaInicial;

public class PintarInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pintar_inicio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView bsc = findViewById(R.id.buscador);

        bsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PintarInicio.this, buscador.class);
                startActivity(intent);
            }
        });

        ImageView Home = findViewById(R.id.paginaHome);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PintarInicio.this, PaginaInicial.class);
                startActivity(intent);
            }
        });

        TextView PRI = findViewById(R.id.GoPrincipiante);
        PRI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PintarInicio.this, PiPrincipiante.class);
                startActivity(intent);
            }
        });

        TextView INT = findViewById(R.id.GoIntermedio);
        INT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PintarInicio.this, PiIntermedio.class);
                startActivity(intent);
            }
        });

        TextView AVA = findViewById(R.id.GoAvanzado);
        AVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PintarInicio.this, PiAvanzado.class);
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