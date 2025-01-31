package com.example.tiendagunpla.Montar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tiendagunpla.R;
import com.example.tiendagunpla.inicio.MainActivity;
import com.example.tiendagunpla.modelos.fgVentana;

public class Principiante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principiante);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView Home = findViewById(R.id.paginaHome);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Principiante.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageView thumbnail = findViewById(R.id.thumbnail);
        thumbnail.setOnClickListener(v -> {
            String videoId = "4gVXbZhLxIE&ab";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?app=desktop&v=4gVXbZhLxIE&ab_channel=ZakuAurelius" + videoId));
            intent.putExtra("force_fullscreen", true);
            startActivity(intent);
        });

    }

}