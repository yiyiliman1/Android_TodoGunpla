package com.example.tiendagunpla;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Clase MisProductos que representa cada ítem de la lista dentro de un RecyclerView.
 * Esta clase es responsable de asociar las vistas de cada ítem con los datos correspondientes.
 */
public class MisProductos extends RecyclerView.ViewHolder {

    // Declaramos las vistas que vamos a utilizar para mostrar los datos del producto
    ImageView pr;  // Imagen del producto
    TextView mdl;  // Nombre del modelo
    TextView nmb;  // Nombre del producto

    /**
     * Constructor de la clase MisProductos.
     * Este método se llama para inicializar las vistas del ViewHolder
     * con las vistas correspondientes que se encuentran en el XML.
     *
     * @param itemView la vista del ítem que se utilizará en el RecyclerView.
     */
    public MisProductos(@NonNull View itemView) {
        super(itemView);  // Llamada al constructor de ViewHolder con la vista del ítem

        // Inicializamos las vistas utilizando el método findViewById
        pr = itemView.findViewById(R.id.fotoPerfil);  // Asocia la vista de la imagen con la variable 'pr'
        mdl = itemView.findViewById(R.id.modelo);     // Asocia la vista del modelo con la variable 'mdl'
        nmb = itemView.findViewById(R.id.nombre);     // Asocia la vista del nombre con la variable 'nmb'
    }
}
