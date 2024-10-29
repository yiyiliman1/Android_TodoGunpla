package com.example.tiendagunpla;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        VideoView videoView = findViewById(R.id.amv);
        ImageView imageView = findViewById(R.id.start);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.amv);
        videoView.setVideoURI(videoUri);
        videoView.start();
        videoView.setOnCompletionListener(mp -> videoView.start());
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(2000); // Duración de la animación en milisegundos
        fadeIn.setStartOffset(700); // Espera antes de comenzar la animación
        fadeIn.setFillAfter(true); // Mantiene el texto visible después de la animación

        // Inicia la animación en el TextView
        imageView.startAnimation(fadeIn);
        imageView.setAlpha(1.0f);

        ImageView st = findViewById(R.id.start);

        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inicio.this, iniciarSesion.class);
                startActivity(intent);
            }
        });
    }

}