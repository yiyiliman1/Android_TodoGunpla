package com.example.tiendagunpla.inicio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tiendagunpla.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class iniciarSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_iniciar_sesion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Te lleva a la ventana Crear Cuenta
        TextView irCC = findViewById(R.id.irCrearCuenta);

        irCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(iniciarSesion.this, crearCuenta.class);
                startActivity(intent);
            }
        });


    }
    // iniciar sesion
    public void iniSesi(View view) {
        FirebaseFirestore database = FirebaseFirestore.getInstance();

        TextView username = findViewById(R.id.TextUsu);
        TextView password = findViewById(R.id.TextContra);

        String usuario = username.getText().toString();
        String contra = password.getText().toString();

        // Consultar Firestore para verificar las credenciales
        database.collection("users").document(usuario)
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                // Obtener la contraseña almacenada
                                String contrasenaAlmacenada = document.getString("password");
                                // Comparar contraseñas
                                if (contrasenaAlmacenada != null && contrasenaAlmacenada.equals(contra)) {
                                    // Contraseñas coinciden, navegar a la actividad principal
                                    Toast.makeText(iniciarSesion.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(iniciarSesion.this, PaginaInicial.class);
                                    startActivity(intent);
                                } else {
                                    // Contraseña incorrecta
                                    Toast.makeText(iniciarSesion.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                // Usuario no encontrado
                                Toast.makeText(iniciarSesion.this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // Error al realizar la consulta
                            Toast.makeText(iniciarSesion.this, "Error al acceder a los datos", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}