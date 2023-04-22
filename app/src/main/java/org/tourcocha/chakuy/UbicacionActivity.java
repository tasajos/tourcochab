package org.tourcocha.chakuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.GoogleMap;



public class UbicacionActivity extends AppCompatActivity implements OnMapReadyCallback {

    private String ubicacion;
    private String ubicacionTotal;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);
        GoogleMap mMap;
        ubicacion = getIntent().getStringExtra("ubicacion");
        this.setTitle("Ubicacion");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ubicacionTotal = getIntent().getStringExtra("ubicacion");

        MapView mapView = findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.onPause();
        mapView.getMapAsync(this);


    }
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Extraer las coordenadas de la ubicación
        String[] parts = ubicacion.split(",");
        double lat = Double.parseDouble(parts[0]);
        double lng = Double.parseDouble(parts[1]);
        LatLng location = new LatLng(lat, lng);

        // Agregar un marcador en la ubicación y mover la cámara
        mMap.addMarker(new MarkerOptions().position(location).title("Ubicación"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15));
    }


    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}