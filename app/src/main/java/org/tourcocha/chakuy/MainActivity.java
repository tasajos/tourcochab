package org.tourcocha.chakuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;

import java.net.URLEncoder;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtVersion = findViewById(R.id.txtversion);
        txtVersion.setText("Version: " + BuildConfig.VERSION_NAME);

        ImageButton btn3registrar = findViewById(R.id.imageButton1);
        ImageButton btnasistencia = findViewById(R.id.imgbtnservicio);


        btn3registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,registrarevento.class);
                startActivity(intent);
            }
        });

        btnasistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,servicios.class);
                startActivity(intent);
            }
        });




    }



    public void openWhatsApp(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=70776212"));
        startActivity(intent);
    }

}
