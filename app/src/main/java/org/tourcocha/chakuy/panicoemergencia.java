package org.tourcocha.chakuy;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.Arrays;
import java.util.List;

public class panicoemergencia extends AppCompatActivity {
    ImageButton btnalarma;
    EditText ubicacion;
    private FusedLocationProviderClient fusedLocationClient;
    private Location lastKnownLocation;
    private static final int PERMISSION_REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panicoemergencia);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        this.setTitle("Emergencias");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ubicacion = findViewById(R.id.ubicacion);
        btnalarma = findViewById(R.id.btnalarma);

        btnalarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = ubicacion.getText().toString();
                sendWhatsAppMessage(message); // Handle button click if needed
            }
        });
    }

    private void sendWhatsAppMessage(String message) {
        String phoneNumber = "+59170776212"; // Replace with the desired phone number

        // Get the latitude and longitude coordinates from the EditText
        String[] coordinates = ubicacion.getText().toString().split(",");
        String latitude = coordinates[0].trim();
        String longitude = coordinates[1].trim();

        // Create a link for opening the location in Google Maps
        String mapLink = "https://www.google.com/maps?q=" + latitude + "," + longitude;

        // Construct the WhatsApp URL with the phone number and map link
        String url = "https://api.whatsapp.com/send?phone=" + phoneNumber + "&text=" + Uri.encode(mapLink);

        // Create an Intent with ACTION_VIEW and the WhatsApp URL
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        // Start the activity with the Intent
        startActivity(intent);
    }
    @Override
    protected void onResume() {
        super.onResume();

        // Primero, asegurarse de tener permisos de ubicación
        if (ActivityCompat.checkSelfPermission(panicoemergencia.this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(panicoemergencia.this, ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(panicoemergencia.this, new String[]{ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION}, PERMISSION_REQUEST_CODE);
        } else {
            // Si ya tiene los permisos, obtener la ubicación
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                // Guardar la ubicación en la variable lastKnownLocation
                                lastKnownLocation = location;
                                ubicacion.setText(location.getLatitude() + " ," + location.getLongitude());
                            }
                        }
                    });
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}