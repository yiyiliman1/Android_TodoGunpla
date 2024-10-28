package com.example.tiendagunpla;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.Firebase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class crearCuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crear_cuenta);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Te lleva a la ventana Iniciar Sesión
        TextView irIS = findViewById(R.id.irIniciarSesion);

        irIS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(crearCuenta.this, iniciarSesion.class);
                startActivity(intent);
            }
        });
    }
    public void Registro(View view) {
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        Map<String, Object> values = new HashMap<>();
        TextView username = findViewById(R.id.TextUsu);
        TextView email = findViewById(R.id.TextContra);
        TextView password = findViewById(R.id.TextReContra);

        values.put("name", username.getText().toString());
        values.put("email", email.getText().toString());
        values.put("password", password.getText().toString());

        database.collection("users").document(username.getText().toString())
                .set(values);
        Intent intent = new Intent(crearCuenta.this, iniciarSesion.class);
        startActivity(intent);
    }

}