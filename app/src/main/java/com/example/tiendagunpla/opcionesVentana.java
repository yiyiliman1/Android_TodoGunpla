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

import com.example.tiendagunpla.inicio.MainActivity;
import com.example.tiendagunpla.inicio.crearCuenta;
import com.example.tiendagunpla.inicio.iniciarSesion;

public class opcionesVentana extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_opciones_ventana);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Te lleva a la ventana Iniciar sesión
        TextView txtIS = findViewById(R.id.textoIniciarsesion);

        txtIS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(opcionesVentana.this, iniciarSesion.class);
                startActivity(intent);
            }
        });

        // Te lleva a la ventana Crear Cuenta
        TextView txtRC = findViewById(R.id.textoRegistrarse);

        txtRC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(opcionesVentana.this, crearCuenta.class);
                startActivity(intent);
            }
        });

        // Te lleva a la ventana HOME
        ImageView paginaHome = findViewById(R.id.paginaHome);

        paginaHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(opcionesVentana.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Te lleva a la ventana Sobre Nosotros
        TextView txtSN = findViewById(R.id.textoSobrenosotros);

        txtSN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(opcionesVentana.this, sobreNosotros.class);
                startActivity(intent);
            }
        });
    }
}