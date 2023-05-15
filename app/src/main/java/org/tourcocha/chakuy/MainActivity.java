package org.tourcocha.chakuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;

import com.google.firebase.inappmessaging.FirebaseInAppMessaging;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

// Verificar si el intent contiene un enlace de URL
        if (intent.getData() != null) {
            // Obtener la URL del intent
            Uri uri = intent.getData();

            // Abrir la URL en un navegador web
            Intent webIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(webIntent);
        }

        TextView txtVersion = findViewById(R.id.txtversion);
        txtVersion.setText("Version: " + BuildConfig.VERSION_NAME);

        ImageButton btn3registrar = findViewById(R.id.imageButton1);
        ImageButton btnasistencia = findViewById(R.id.imgbtnservicio);
        ImageButton btnmapa = findViewById(R.id.imageButton2);
        LinearLayout listado = findViewById(R.id.lugares);
        LinearLayout ruteo = findViewById(R.id.ruteo);
        LinearLayout ferias = findViewById(R.id.comidas);
        LinearLayout servemerge = findViewById(R.id.servemer);

        ImageButton btnpanico = findViewById(R.id.btnSirena);


        servemerge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,servicios.class);
                startActivity(intent);
            }
        });


        listado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ActividadesResum.class);
                startActivity(intent);
            }
        });

        ferias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,feriasactivity.class);
                startActivity(intent);
            }
        });

        ruteo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RuteoActivity.class);
                startActivity(intent);
            }
        });


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

        btnpanico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,panicoemergencia.class);
                startActivity(intent);

            }
        });

        btnmapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,mapass.class);
                startActivity(intent);
            }
        });




    }



    public void openWhatsApp(View view) {
        String message = "*Turista - Cocha* Quisiera mas informacion";
        String phoneNumber = "+59177087685";
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=" + phoneNumber + "&text=" + URLEncoder.encode(message, "UTF-8")));
            startActivity(intent);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void openFacebook(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.facebook.com/turistacocha"));
        startActivity(intent);
    }

}
