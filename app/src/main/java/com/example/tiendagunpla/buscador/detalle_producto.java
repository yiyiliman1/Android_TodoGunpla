package com.example.tiendagunpla.buscador;

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

import com.example.tiendagunpla.R;
import com.example.tiendagunpla.inicio.MainActivity;

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

        // atras
        ImageView aT = findViewById(R.id.atras);

        aT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(detalle_producto.this, MainActivity.class);
                startActivity(intent);
            }
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
                            "Escala y Tamaño: Es una maqueta en escala 1/144, lo que lo hace compacto y fácil de exhibir. Suele tener una altura de unos 12-13 cm una vez ensamblado.\n" +
                            "\n" +
                            "Nivel de Dificultad: Al ser un modelo FG (First Grade), está diseñado para principiantes en el mundo de las maquetas de Gundam. No requiere pegamento, y el montaje es relativamente sencillo, ya que las piezas se ensamblan con un sistema de encaje. No es tan articulado como otros modelos, pero es ideal para quienes comienzan o quieren una pieza simple.\n" +
                            "\n" +
                            "Diseño y Detalles: Representa al clásico RX-78-2, el Gundam icónico de la serie original Mobile Suit Gundam. Su apariencia es la de un \"mecha\" de combate, con los colores característicos: blanco, azul, rojo y amarillo. Incluye detalles que lo hacen muy reconocible, como el escudo (shield), la beam rifle y la V-fin (antenas amarillas en forma de V).\n" +
                            "\n" +
                            "Estética y Nostalgia: Es perfecto para coleccionistas que valoran el diseño clásico de Gundam. Además, es una forma económica de tener el icónico RX-78-2 en la colección, ideal para quienes disfrutan del aspecto retro y simple de los modelos FG.");
                    break;
                case "fg_exia":
                    productoImagen.setImageResource(R.drawable.fg_exia);
                    productoDescripcion.setText("El Gundam FG 1/144 Exia es un modelo de Bandai que pertenece a la línea FG (First Grade), una colección accesible para fanáticos y coleccionistas de Gundam, especialmente diseñada para quienes desean construir maquetas de bajo nivel de dificultad sin comprometer detalles icónicos.\n" +
                            "\n" +
                            "Escala y Tamaño\n" +
                            "Esta maqueta está en escala 1/144, lo cual la hace compacta y fácil de exponer. Al ensamblarse, suele alcanzar unos 12-13 cm de altura, conservando proporciones y detalles significativos del Exia de la serie Mobile Suit Gundam 00.\n" +
                            "Diseño y Detalles\n" +
                            "El Exia es famoso por su estética ágil y afilada, destacándose por su diseño único de combate cuerpo a cuerpo. Viene en los colores característicos: blanco, azul, rojo y gris metálico, y conserva detalles importantes como la GN Sword, las GN Blades y su distintivo visor verde en el casco.\n" +
                            "\n" +
                            "Estética y Nostalgia\n" +
                            "Esta maqueta FG permite a los fans de Gundam 00 tener una representación económica del Exia, un mecha icónico por su estilo elegante y futurista. Es perfecta para coleccionistas que buscan una pieza sencilla y representativa, que evoca la esencia de la serie sin la complejidad de ensamblaje de modelos avanzados.");
                    break;
                case "fg_dynames":
                    productoImagen.setImageResource(R.drawable.fg_dynames);
                    productoDescripcion.setText("El Gundam FG 1/144 Dynames es una maqueta de Bandai en escala 1/144, ideal para principiantes. Al ser de la línea FG, su montaje es simple, sin necesidad de pegamento y con pocas articulaciones. El diseño captura la esencia del Dynames de Gundam 00, destacando sus colores verde, blanco y gris, y su característico rifle de francotirador GN. Es una opción económica y compacta (unos 12-13 cm) para fans que desean una pieza fácil de ensamblar y exponer.");
                    break;
                case "fg_kyrios":
                    productoImagen.setImageResource(R.drawable.fg_kyrios);
                    productoDescripcion.setText("Gundam FG 1/144 Kyrios: Este modelo de Bandai en escala 1/144 es ideal para principiantes, ofreciendo un montaje sencillo sin pegamento. Representa al Kyrios de Gundam 00, con su distintivo diseño transformable y colores naranja, blanco y gris. Aunque tiene pocas articulaciones, mantiene el estilo aerodinámico y las alas características del Kyrios, ideal para fans que buscan una pieza accesible y compacta de exhibir.");
                    break;
                case "fg_virtue":
                    productoImagen.setImageResource(R.drawable.fg_virtue);
                    productoDescripcion.setText("Gundam FG 1/144 Virtue: En la misma línea FG, este modelo simplificado captura la esencia robusta del Virtue de Gundam 00, en escala 1/144 y con ensamblaje fácil. Con su diseño masivo y colores blanco y negro, incluye detalles como el cañón GN Bazooka, perfecto para quienes desean un modelo imponente y sencillo de construir y exhibir en su colección.");
                    break;
                case "hg_gundam":
                    productoImagen.setImageResource(R.drawable.hg_gundam_original);
                    productoDescripcion.setText("Gundam HG 1/144 RX-78-2: El RX-78-2 es el modelo emblemático de la franquicia Gundam, y esta versión HG en escala 1/144 es una de las más accesibles y queridas por coleccionistas. Su diseño clásico en colores blanco, azul, rojo y amarillo lo hace instantáneamente reconocible, representando fielmente al Gundam original de Mobile Suit Gundam. El modelo HG cuenta con una buena gama de articulaciones, lo que permite gran libertad de poses. Incluye accesorios icónicos como el beam rifle, el escudo y el beam saber, ofreciendo opciones de personalización y poses de combate. Este RX-78-2 es ideal tanto para coleccionistas nostálgicos como para aquellos que inician en el mundo del modelismo Gundam, ya que logra un equilibrio entre simplicidad, detalle y flexibilidad, convirtiéndolo en una pieza obligatoria en cualquier colección de Gundam.");
                    break;
                case "hg_oo":
                    productoImagen.setImageResource(R.drawable.hg_oo);
                    productoDescripcion.setText("Gundam HG 1/144 00: Esta maqueta de Bandai en escala 1/144 del Gundam 00 de Gundam 00 ofrece un nivel intermedio de detalle y flexibilidad, ideal tanto para coleccionistas como para modelistas en etapa de aprendizaje. Al ser un modelo HG (High Grade), su ensamblaje es intuitivo, y el sistema de piezas proporciona una gran poseabilidad. Su diseño elegante y estilizado destaca por los colores clásicos de la serie: blanco, azul y gris, que resaltan el aspecto futurista del mecha. Incluye armamento icónico como las GN Swords y GN Shields, que le dan una apariencia dinámica y agresiva. Este modelo es ideal para quienes buscan una representación atractiva y poseable del Gundam 00, combinando detalles y una buena experiencia de montaje.");
                    break;
                case "hg_strike_freedom":
                    productoImagen.setImageResource(R.drawable.hg_strike_freedom);
                    productoDescripcion.setText("Gundam HG 1/144 Strike Rouge Perfect: Este modelo HG de Bandai reproduce fielmente al Gundam Strike Rouge de Gundam SEED, conocido por su llamativo esquema de colores en tonos rosados y blancos. La variante \"Perfect\" incluye el Aile Striker Pack, que le otorga un aspecto imponente con sus alas y propulsores, haciendo que el Strike Rouge se vea listo para el combate aéreo. Su diseño incluye articulaciones avanzadas para la escala, lo que permite recrear poses dinámicas y fieles a la serie. Además, el armado es relativamente sencillo y bien organizado, pensado para quienes desean una maqueta con detalles adicionales y mejor capacidad de exhibición. Es perfecto para fanáticos que buscan un modelo con un estilo único y una presencia impactante en cualquier colección.");
                    break;
                case "mg_freedom":
                    productoImagen.setImageResource(R.drawable.mg_freedom);
                    productoDescripcion.setText("Gundam MG 1/100 Freedom: Este modelo Master Grade de Bandai en escala 1/100 del Gundam Freedom de Gundam SEED es una de las representaciones más detalladas de esta unidad. El diseño de este MG ofrece una estructura interna compleja y piezas altamente articuladas, que permiten una excelente poseabilidad, en especial con sus alas desplegables y su arsenal de armas de largo alcance. Los colores azul, blanco y negro del Freedom están cuidadosamente recreados, y los detalles en el sistema de armas –como los cañones de plasma de alta energía, beam sabers y el railgun– se destacan por su nivel de precisión. Además, las alas pueden abrirse y cerrarse, recreando las poses aéreas icónicas de la serie. Este MG es ideal para fans que buscan una maqueta desafiante y altamente poseable con una apariencia majestuosa y poderosa en cualquier vitrina.");
                    break;
                case "mg_buster":
                    productoImagen.setImageResource(R.drawable.mg_buster);
                    productoDescripcion.setText("Gundam MG 1/100 Buster: El MG Buster Gundam en escala 1/100 captura el carácter robusto y especializado del francotirador de artillería de Gundam SEED. Este modelo Master Grade destaca por su sólida estructura y su variedad de opciones de armamento pesado, como el lanzador de alta energía y el cañón de impulso. Su sistema de armas es modular y permite combinaciones únicas, dando flexibilidad para recrear poses de combate precisas. El esquema de colores en verde, gris y blanco es fiel a la serie, y el detalle en el diseño interno proporciona una experiencia de construcción compleja y satisfactoria. Además, las articulaciones reforzadas permiten soportar el peso del armamento, manteniendo la estabilidad en cualquier pose. Es un modelo ideal para coleccionistas que disfrutan de los mechas pesados y buscan una maqueta que combine precisión en detalles y versatilidad de exhibición.");
                    break;
                case "mg_barbatos":
                    productoImagen.setImageResource(R.drawable.mg_barbatos);
                    productoDescripcion.setText("Gundam MG 1/100 Barbatos: Este modelo MG en escala 1/100 del Gundam Barbatos de Mobile Suit Gundam: Iron-Blooded Orphans es una representación impresionante de este mecha icónico, con una estructura esquelética interna que permite una amplia gama de poses y estabilidad. El Barbatos se destaca por su diseño robusto y su aspecto de combate cuerpo a cuerpo, con detalles de desgaste en la armadura para una apariencia más realista y agresiva. Incluye accesorios como la característica mace y espada, todos detallados y fáciles de manejar en poses dinámicas. Los colores blanco, gris, azul y amarillo están recreados con precisión, y la armadura puede ajustarse para mostrar el esqueleto interno, añadiendo un nivel extra de personalización. Este modelo es perfecto para fans que buscan una construcción compleja y un diseño que resalte en cualquier colección por su estilo brutal y altamente articulado.");
                    break;
                case "rg_freedom":
                    productoImagen.setImageResource(R.drawable.rg_freedom);
                    productoDescripcion.setText("Gundam RG 1/144 Freedom: El modelo RG de Bandai del Freedom Gundam de Gundam SEED en escala 1/144 combina la complejidad de un Master Grade con el tamaño compacto de un High Grade. Este RG cuenta con una estructura interna avanzada que permite un rango de movimiento excepcional, ideal para recrear poses aéreas y de combate. Sus alas están diseñadas para desplegarse y moverse con gran precisión, mientras que sus armas, como los cañones de plasma, railguns y beam sabers, están exquisitamente detalladas. Los colores en azul, blanco y negro resaltan gracias a paneles adicionales que añaden profundidad y realismo, convirtiéndolo en una maqueta que impacta visualmente.");
                    break;
                case "rg_exia":
                    productoImagen.setImageResource(R.drawable.rgexia);
                    productoDescripcion.setText("Gundam RG 1/144 Exia: El Gundam Exia en versión RG es un modelo compacto y detallado del icónico mecha de Gundam 00. La estructura interna, inspirada en el esqueleto de los Mobile Suits, permite una poseabilidad sobresaliente y realismo, ideal para poses de combate cuerpo a cuerpo. El modelo incluye las GN Swords y otras armas características del Exia, con detalles transparentes en los GN Condensers que le otorgan un aspecto futurista. Su esquema de colores en blanco, azul, rojo y gris está bien diferenciado, y las piezas adicionales permiten recrear un look dinámico y fiel al anime.");
                    break;
                case "rg_destiny":
                    productoImagen.setImageResource(R.drawable.rgdestiny);
                    productoDescripcion.setText("Gundam RG 1/144 Destiny: Este modelo RG del Destiny Gundam de Gundam SEED Destiny ofrece una experiencia de montaje detallada y compleja. El Destiny es conocido por su versatilidad en combate y su aspecto imponente, cualidades que el modelo RG captura mediante sus alas y armamento variado, como la Palma de Luz (Palma Fiocina) y el Anti-Ship Sword. Las alas están diseñadas para desplegarse con una gran movilidad y las articulaciones permiten poses dinámicas. El esquema de colores rojo, azul y blanco, junto con detalles adicionales, hacen que el Destiny Gundam luzca robusto y poderoso, ideal para exhibiciones.");
                    break;
                case "rg_impulse":
                    productoImagen.setImageResource(R.drawable.rgimpul);
                    productoDescripcion.setText("Gundam RG 1/144 Impulse: El Real Grade Impulse Gundam en escala 1/144 reproduce fielmente el diseño multifuncional del Impulse de Gundam SEED Destiny. Este RG tiene una estructura interna detallada que permite alta articulación, ideal para cambiar entre el Core Splendor y las partes de combate. Las armas, como la beam rifle, escudo y Anti-Ship Sword, están diseñadas con gran precisión, permitiendo recrear poses de combate icónicas. Su diseño modular y el esquema de colores blanco, azul y rojo hacen que el Impulse se vea imponente y fiel al anime, ofreciendo a los fans una maqueta compacta pero llena de detalles.");
                    break;
                case "pg_freedom":
                    productoImagen.setImageResource(R.drawable.pg_freedom);
                    productoDescripcion.setText("Gundam PG 1/60 Freedom: Este modelo PG del Freedom Gundam de Gundam SEED en escala 1/60 es una de las representaciones más detalladas y majestuosas de este Mobile Suit. Su diseño destaca por una estructura interna completamente articulada y reforzada, que permite poses de combate y despliegue de alas con una estabilidad excepcional. Las alas, uno de los puntos más característicos del Freedom, están articuladas y pueden desplegarse con movimiento individual en cada panel, creando una apariencia expansiva e imponente. La maqueta incluye un arsenal completo, como los cañones de plasma, railguns y beam sabers, cada uno detallado hasta el más mínimo aspecto. Además, el esquema de colores en azul, blanco y negro está complementado con detalles de paneles que realzan la textura y apariencia del Freedom. Este modelo es ideal para coleccionistas que buscan una maqueta de gran tamaño y presencia, que capture la esencia poderosa del Freedom Gundam.");
                    break;
                case "pg_exia":
                    productoImagen.setImageResource(R.drawable.pg_exia);
                    productoDescripcion.setText("Gundam PG 1/60 Exia: El PG Gundam Exia en escala 1/60 es una obra maestra que representa fielmente al mecha de Gundam 00, con una estructura interna elaborada que permite un rango de movimiento superior y un realismo impresionante. Este modelo incluye iluminación LED en los GN Condensers y en el visor, lo cual le da un aspecto futurista y resalta la energía del Exia en combate. Las articulaciones reforzadas permiten recrear poses de combate cuerpo a cuerpo, algo fundamental para el estilo de lucha del Exia. Los detalles en las GN Swords y GN Blades son meticulosos, e incluyen partes metálicas para añadir realismo y durabilidad. Los colores en blanco, azul, rojo y gris, junto con las partes transparentes en los condensadores, hacen que el modelo luzca impresionante tanto de día como de noche con la iluminación activada. Este PG es perfecto para quienes buscan una experiencia de montaje avanzada y una representación detallada y dinámica del icónico Gundam Exia.");
                    break;
            }
        }
    }
}
