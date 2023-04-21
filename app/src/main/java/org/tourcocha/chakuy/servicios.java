package org.tourcocha.chakuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class servicios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);


        ImageButton registro = findViewById(R.id.imageButton1);
        ImageButton btnasistencia = findViewById(R.id.imgbtnservicio);
        ImageButton mapas = findViewById(R.id.imageButton2);




        TextView txtVersion = findViewById(R.id.txtversion);
        txtVersion.setText("Version: " + BuildConfig.VERSION_NAME);

        this.setTitle("Servicios");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(servicios.this,registrarevento.class);
                startActivity(intent);
            }
        });

        mapas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(servicios.this,mapass.class);
                startActivity(intent);
            }
        });

            }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;

    }
    public void openWhatsApp(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=70776212"));
        startActivity(intent);
    }

}