package org.tourcocha.chakuy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.UiAutomation;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView;
import android.net.Uri;
import android.app.DatePickerDialog;
import android.widget.DatePicker;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
public class registrarevento extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {




    Button btn_registrar;


    //private EditText ubicacionEditText;
    EditText ubicacion,ubicacion2;

    GoogleMap mMap;
    private EditText mFechaEditText;
    EditText nombre,apellido,tipo,detalle,pedido,fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarevento);
        mFechaEditText = findViewById(R.id.fecha);

        ubicacion = findViewById(R.id.ubicacion);
        ubicacion2 = findViewById(R.id.ubicacion2);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        this.setTitle("Crear Registro Evento");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = findViewById(R.id.nombre);
        //apellido = findViewById(R.id.apellido);
        detalle = findViewById(R.id.detalle);
        Spinner tipoSpinner = findViewById(R.id.tipo_spinner);
        pedido = findViewById(R.id.pedido);
        ubicacion = findViewById(R.id.ubicacion);
        fecha    = findViewById(R.id.fecha);




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
    public void mostrarDatePicker(View view) {
        // Obtener la fecha actual
        final Calendar c = Calendar.getInstance();
        int anio = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);
        int dia = c.get(Calendar.DAY_OF_MONTH);

        // Crear el diálogo DatePicker y establecer la fecha actual como fecha predeterminada
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // Actualizar el campo de fecha con la fecha seleccionada
                        mFechaEditText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, anio, mes, dia);

        // Mostrar el diálogo DatePicker
        datePickerDialog.show();
    }

    public String crearMensaje() {
        String nombreStr = nombre.getText().toString();
        String apellidoStr = apellido.getText().toString();
        String detalleStr = detalle.getText().toString();
        String pedidoStr = pedido.getText().toString();
        String ubicacionStr = ubicacion.getText().toString();
        String ubicacion2Str = ubicacion2.getText().toString();
        String fechaStr = fecha.getText().toString();

        // Concatenar los valores en una cadena de mensaje
        String mensaje = "Nombre: " + nombreStr + "\n" +
                "Apellido: " + apellidoStr + "\n" +
                "Detalle: " + detalleStr + "\n" +
                "Nro: " + pedidoStr + "\n" +
                "Ubicación Long: " + ubicacionStr + "\n" +
                "Ubicación Lat: " + ubicacion2Str + "\n" +
                "Fecha: " + fechaStr;

        return mensaje;
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    // ...
}

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

            mMap = googleMap;
            this.mMap.setOnMapClickListener(this);
            this.mMap.setOnMapLongClickListener(this);

LatLng bolivia = new LatLng(-17.3939986,-66.3197696);
mMap.addMarker(new MarkerOptions().position(bolivia).title("Cochabamba"));
mMap.moveCamera(CameraUpdateFactory.newLatLng(bolivia));


    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {

        ubicacion.setText(""+latLng.latitude);
        ubicacion2.setText(""+latLng.longitude);

        mMap.clear();

        LatLng bolivia = new LatLng(latLng.latitude,latLng.longitude);
        mMap.addMarker(new MarkerOptions().position(bolivia).title(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bolivia));

    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {

        ubicacion.setText(""+latLng.latitude);
        ubicacion2.setText(""+latLng.longitude);

        mMap.clear();

        LatLng bolivia = new LatLng(latLng.latitude,latLng.longitude);
        mMap.addMarker(new MarkerOptions().position(bolivia).title(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bolivia));

    }
}


