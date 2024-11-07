package com.example.tiendagunpla;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class detalle_producto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalle_producto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView productoImagen = findViewById(R.id.productoImagen);
        TextView productoDescripcion = findViewById(R.id.productoDescripcion);

        String productoId = getIntent().getStringExtra("producto_id");

        if (productoId != null) {
            switch (productoId) {
                case "fg_gundam":
                    productoImagen.setImageResource(R.drawable.fg_gundam);
                    productoDescripcion.setText("El Gundam FG 1/144 RX-78-2 - Nº 01 es un modelo de la línea de maquetas de Gundam de Bandai, específicamente en la escala 1/144, lo que significa que es una réplica detallada pero en una versión más pequeña y accesible para los coleccionistas y fanáticos.\n" +
                            "\n" +
                            "Aquí tienes una descripción del modelo:\n" +
                            "\n" +
                            "Escala y Tamaño: Es una maqueta en escala 1/144, lo que lo hace compacto y fácil de exhibir. Suele tener una altura de unos 12-13 cm una vez ensamblado.\n" +
                            "\n" +
                            "Nivel de Dificultad: Al ser un modelo FG (First Grade), está diseñado para principiantes en el mundo de las maquetas de Gundam. No requiere pegamento, y el montaje es relativamente sencillo, ya que las piezas se ensamblan con un sistema de encaje. No es tan articulado como otros modelos, pero es ideal para quienes comienzan o quieren una pieza simple.\n" +
                            "\n" +
                            "Diseño y Detalles: Representa al clásico RX-78-2, el Gundam icónico de la serie original Mobile Suit Gundam. Su apariencia es la de un \"mecha\" de combate, con los colores característicos: blanco, azul, rojo y amarillo. Incluye detalles que lo hacen muy reconocible, como el escudo (shield), la beam rifle y la V-fin (antenas amarillas en forma de V).\n" +
                            "\n" +
                            "Accesorios y Articulación: Al ser un modelo básico, sus articulaciones son más limitadas que las versiones más avanzadas. Aunque el FG no tiene tanta movilidad ni accesorios detallados, se captura bien la esencia del RX-78-2.\n" +
                            "\n" +
                            "Estética y Nostalgia: Es perfecto para coleccionistas que valoran el diseño clásico de Gundam. Además, es una forma económica de tener el icónico RX-78-2 en la colección, ideal para quienes disfrutan del aspecto retro y simple de los modelos FG.");
                    break;
                case "fg_exia":
                    productoImagen.setImageResource(R.drawable.fg_exia);
                    productoDescripcion.setText("Descripción de FG Exia");
                    break;
                case "fg_dynames":
                    productoImagen.setImageResource(R.drawable.fg_dynames);
                    productoDescripcion.setText("Descripción de FG Dynames");
                    break;
                case "fg_kyrios":
                    productoImagen.setImageResource(R.drawable.fg_kyrios);
                    productoDescripcion.setText("Descripción de FG Kyrios");
                    break;
                case "fg_virtue":
                    productoImagen.setImageResource(R.drawable.fg_virtue);
                    productoDescripcion.setText("Descripción de FG Virtue");
                    break;
            }
        }
    }
}
