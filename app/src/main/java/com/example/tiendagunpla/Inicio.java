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
        // Obtiene el VideoView desde el diseño para reproducir el video de bienvenida
        VideoView videoView = findViewById(R.id.amv);

        // Obtiene el ImageView que se utilizará para la animación de inicio
        ImageView imageView = findViewById(R.id.start);

        // Configura el URI del video desde la carpeta de recursos "raw" usando el nombre de archivo "amv"
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.amv);

        // Asigna el URI al VideoView y lo reproduce automáticamente
        videoView.setVideoURI(videoUri);
        videoView.start();

        // Configura el video para que se repita en bucle al terminar
        videoView.setOnCompletionListener(mp -> videoView.start());

        // Crea una animación de "fade in" para el ImageView
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f); // Configura el rango de opacidad: de 0% a 100%
        fadeIn.setDuration(2000); // Duración de la animación (en milisegundos)
        fadeIn.setStartOffset(700); // Retraso antes de iniciar la animación (en milisegundos)
        fadeIn.setFillAfter(true); // Mantiene el estado final de la animación

        // Inicia la animación de "fade in" en el ImageView
        imageView.startAnimation(fadeIn);
        imageView.setAlpha(1.0f); // Asegura que la imagen esté completamente visible al terminar

        // Configura el botón de inicio para pasar a la pantalla de inicio de sesión al hacer clic
        ImageView st = findViewById(R.id.start);
        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crea una intención para iniciar la actividad "iniciarSesion"
                Intent intent = new Intent(Inicio.this, iniciarSesion.class);
                startActivity(intent); // Inicia la actividad de inicio de sesión
            }
        });
    }

}