package org.tourcocha.chakuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.PopupWindow;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class servicios extends AppCompatActivity {

    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);


        ImageButton registro = findViewById(R.id.imageButton1);
        ImageButton btnasistencia = findViewById(R.id.imgbtnservicio);
        ImageButton mapas = findViewById(R.id.imageButton2);
        LinearLayout emergencias = findViewById(R.id.emergencias);
        LinearLayout turismo = findViewById(R.id.Turismo);
        LinearLayout asistencia = findViewById(R.id.asistencia);




        TextView txtVersion = findViewById(R.id.txtversion);
        txtVersion.setText("Version: " + BuildConfig.VERSION_NAME);

        this.setTitle("Servicios");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        turismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Assuming that 'view' is the View object that the OnClickListener is attached to
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                builder.setTitle("Turismo");
                builder.setMessage("Mensaje muy pronto");
                builder.setIcon(R.drawable.logocha);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });





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

        emergencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(servicios.this,ResumeEmergencias.class);
                startActivity(intent);
            }
        });

        asistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(servicios.this,asistenciaviajero.class);
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