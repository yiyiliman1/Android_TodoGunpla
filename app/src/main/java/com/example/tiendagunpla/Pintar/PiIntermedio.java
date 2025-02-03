package com.example.tiendagunpla.Pintar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tiendagunpla.R;
import com.example.tiendagunpla.inicio.PaginaInicial;

public class PiIntermedio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pi_intermedio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        WebView video = findViewById(R.id.webView);
        video.setWebViewClient(new WebViewClient());

        WebSettings webSettings = video.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        video.setLayerType(WebView.LAYER_TYPE_HARDWARE, null);

        String videoHtml = "<html><body style='margin:0;padding:0;'>" +
                "<iframe width='100%' height='100%' src='https://www.youtube.com/embed/MKoeZKg-scI?si=QlDbVN9BtewBKZuO'" +
                " frameborder='0' allow='accelerometer; clipboard-write; encrypted-media; gyroscope; picture-in-picture' " +
                " allowfullscreen></iframe></body></html>";

        video.loadData(videoHtml, "text/html", "utf-8");

        ImageView Home = findViewById(R.id.paginaHome);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PiIntermedio.this, PaginaInicial.class);
                startActivity(intent);
            }
        });
    }
}