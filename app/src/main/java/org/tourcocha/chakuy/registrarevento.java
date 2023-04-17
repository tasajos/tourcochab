package org.tourcocha.chakuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import android.net.Uri;


public class registrarevento extends AppCompatActivity {

    Button btn_registrar;

    EditText nombre,apellido,tipo,detalle,pedido,cantidad,color,precio,ubicacion,fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarevento);

        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        detalle = findViewById(R.id.detalle);
        pedido = findViewById(R.id.pedido);
        cantidad = findViewById(R.id.cantidad);
        color = findViewById(R.id.color);
        precio = findViewById(R.id.precio);
        ubicacion = findViewById(R.id.ubicacion);
        fecha = findViewById(R.id.fecha);


        Button btnRegistrar = findViewById(R.id.btn_registrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensaje = crearMensaje();
                try {
                    String phoneNumber = "77087685"; // Número de teléfono al que se enviará el mensaje
                    String url = "https://api.whatsapp.com/send?phone=" + phoneNumber + "&text=" + URLEncoder.encode(mensaje, "UTF-8");
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "WhatsApp no está instalado", Toast.LENGTH_SHORT).show();
                } catch (UnsupportedEncodingException e) {
                    Toast.makeText(getApplicationContext(), "Error al codificar mensaje", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public String crearMensaje() {
        String nombreStr = nombre.getText().toString();
        String apellidoStr = apellido.getText().toString();
        String detalleStr = detalle.getText().toString();
        String pedidoStr = pedido.getText().toString();
        String cantidadStr = cantidad.getText().toString();
        String colorStr = color.getText().toString();
        String precioStr = precio.getText().toString();
        String ubicacionStr = ubicacion.getText().toString();
        String fechaStr = fecha.getText().toString();

        // Concatenar los valores en una cadena de mensaje
        String mensaje = "Nombre: " + nombreStr + "\n" +
                "Apellido: " + apellidoStr + "\n" +
                "Detalle: " + detalleStr + "\n" +
                "Pedido: " + pedidoStr + "\n" +
                "Cantidad: " + cantidadStr + "\n" +
                "Color: " + colorStr + "\n" +
                "Precio: " + precioStr + "\n" +
                "Ubicación: " + ubicacionStr + "\n" +
                "Fecha: " + fechaStr;

        return mensaje;
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    // ...
}

    }


