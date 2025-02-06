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
import com.example.tiendagunpla.buscador.detalle_producto;

public class hgVentana extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hg_ventana);
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
                Intent intent = new Intent(hgVentana.this, buscador.class);
                startActivity(intent);
            }
        });

        ImageView paginaHome = findViewById(R.id.paginaHome);

        paginaHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(hgVentana.this, MainActivity.class);
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

        // para cada producto
        ImageView hgGundam = findViewById(R.id.hg_gundam);
        ImageView hgoo = findViewById(R.id.hg_oo);
        ImageView hgstrike = findViewById(R.id.hg_strike_freedom);

        hgGundam.setOnClickListener(v -> abrirDetalles("hg_gundam"));
        hgoo.setOnClickListener(v -> abrirDetalles("hg_oo"));
        hgstrike.setOnClickListener(v -> abrirDetalles("hg_strike_freedom"));
    }

    private void abrirDetalles(String productoId) {
        Intent intent = new Intent(this, detalle_producto.class);
        intent.putExtra("producto_id", productoId);
        startActivity(intent);
    }
}