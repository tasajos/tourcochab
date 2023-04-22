package org.tourcocha.chakuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UbicacionActivity extends AppCompatActivity {

    private String ubicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);
        ubicacion = getIntent().getStringExtra("ubicacion");

        this.setTitle("Ubicacion");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}