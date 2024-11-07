package com.example.tiendagunpla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Clase MiAdpatador que es el adaptador para el RecyclerView.
 * Su función es vincular los datos (productos) con las vistas que se mostrarán en la lista del RecyclerView.
 */
public class MiAdpatador extends RecyclerView.Adapter<MisProductos> {

    // Contexto de la aplicación
    Context context;
    // Lista de objetos Productos que serán mostrados en el RecyclerView
    List<Productos> pr;

    /**
     * Constructor del adaptador. Inicializa el contexto y la lista de productos.
     *
     */
    public MiAdpatador(Context context, List<Productos> pr) {
        this.context = context;
        this.pr = pr;
    }

    /**
     * Crea una nueva vista de producto.
     * Esto es llamado por el RecyclerView cuando se necesita una nueva vista para mostrar un ítem.
     *
     * @param parent Vista del contenedor donde el ítem será colocado.
     * @param viewType Tipo de vista.
     * @return Un nuevo ViewHolder (MisProductos) que contiene las vistas del producto.
     */
    @NonNull
    @Override
    public MisProductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla el layout de cada ítem de la lista (productos.xml) y lo pasa al ViewHolder
        return new MisProductos(LayoutInflater.from(context).inflate(R.layout.productos, parent, false));
    }

    /**
     * Asocia los datos del producto con las vistas correspondientes dentro de cada ítem del RecyclerView.
     * Este método se llama para cada ítem que necesita ser renderizado.
     *
     * @param holder ViewHolder donde se asociarán los datos.
     * @param position Posición del producto dentro de la lista.
     */
    @Override
    public void onBindViewHolder(@NonNull MisProductos holder, int position) {
        // Asigna la imagen del producto
        holder.pr.setImageResource(pr.get(position).getImg());
        // Asigna el modelo y nombre del producto
        holder.mdl.setText(pr.get(position).getModelo());
        holder.nmb.setText(pr.get(position).getNombre());
    }

    /**
     * Devuelve el número de ítems que se mostrarán en el RecyclerView (tamaño de la lista de productos).
     *
     * @return El número de productos en la lista.
     */
    @Override
    public int getItemCount() {
        return pr.size();
    }

    /**
     * Filtra la lista de productos y actualiza el RecyclerView con la lista filtrada.
     * Se llama cuando se utiliza un filtro (por ejemplo, en un SearchView).
     *
     * @param listaFiltrada Lista de productos filtrados.
     */
    public void filtrarLista(List<Productos> listaFiltrada) {
        this.pr = listaFiltrada;
        notifyDataSetChanged(); // Notifica que la lista ha cambiado y debe ser actualizada
    }
}
