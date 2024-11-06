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
    /**
     * Método para registrar un nuevo usuario en Firestore.
     * Realiza verificaciones para asegurar que los datos ingresados sean válidos
     * y luego almacena la información en Firestore.
     * En caso de éxito, redirige a la actividad de inicio de sesión.
     */
    public void Registro(View view) {
        FirebaseFirestore database = FirebaseFirestore.getInstance();

        // Obtener referencias a los campos de texto
        TextView username = findViewById(R.id.TextUsu);
        TextView password = findViewById(R.id.TextContra);
        TextView confirmPassword = findViewById(R.id.TextReContra);

        // Obtener valores ingresados
        String nombreUsuario = username.getText().toString().trim();
        String contrasena = password.getText().toString().trim();
        String confirmarContrasena = confirmPassword.getText().toString().trim();

        // Verificar que los campos no estén vacíos
        if (nombreUsuario.isEmpty() || contrasena.isEmpty() || confirmarContrasena.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verificar que la contraseña y confirmación coincidan
        if (!contrasena.equals(confirmarContrasena)) {
            Toast.makeText(this, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verificar si el usuario ya existe en Firebase
        database.collection("users").document(nombreUsuario)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        if (task.getResult().exists()) {
                            // Mensaje si el usuario ya está registrado
                            Toast.makeText(this, "Este usuario ya está registrado.", Toast.LENGTH_SHORT).show();
                        } else {
                            // Preparar datos del nuevo usuario
                            Map<String, Object> values = new HashMap<>();
                            values.put("name", nombreUsuario);
                            values.put("password", contrasena);

                            // Guardar en Firebase Firestore
                            database.collection("users").document(nombreUsuario)
                                    .set(values)
                                    .addOnSuccessListener(aVoid -> {
                                        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(crearCuenta.this, iniciarSesion.class);
                                        startActivity(intent);
                                        finish(); // Finaliza la actividad de registro
                                    })
                                    .addOnFailureListener(e -> Toast.makeText(this, "Error en el registro. Intenta nuevamente.", Toast.LENGTH_SHORT).show());
                        }
                    } else {
                        Toast.makeText(this, "Error al verificar el usuario.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}