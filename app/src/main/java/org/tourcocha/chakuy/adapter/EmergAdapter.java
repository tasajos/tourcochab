package org.tourcocha.chakuy.adapter;

import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import org.tourcocha.chakuy.R;
import org.tourcocha.chakuy.model.EmergModel;
import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import android.util.Log;
import android.app.Activity;


public class EmergAdapter extends FirestoreRecyclerAdapter<EmergModel, EmergAdapter.ViewHolder> {
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public EmergAdapter(@NonNull FirestoreRecyclerOptions<EmergModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull EmergModel EmergModel) {

        viewHolder.nombre.setText(EmergModel.getNombre());
        viewHolder.telefono.setText(EmergModel.getTelefono());
        viewHolder.tipo.setText(EmergModel.getTipo());
        viewHolder.whatsapp.setText(EmergModel.getWhatsapp());



        viewHolder.telefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String phoneNumber = EmergModel.getTelefono().replaceAll("[^0-9]", ""); // formatea el número de teléfono eliminando todos los caracteres no numéricos
                Log.d("EmergAdapter", "Número de teléfono formateado: " + phoneNumber);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                if (ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    Log.d("EmergAdapter", "Permiso CALL_PHONE otorgado");
                    v.getContext().startActivity(intent);
                } else {
                    Log.d("EmergAdapter", "Permiso CALL_PHONE no otorgado");
                    // solicitar permiso CALL_PHONE
                    ActivityCompat.requestPermissions((Activity) v.getContext(), new String[]{Manifest.permission.CALL_PHONE}, 1);
                }
            }
        });
        viewHolder.imgtelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String phoneNumber = EmergModel.getTelefono().replaceAll("[^0-9]", ""); // formatea el número de teléfono eliminando todos los caracteres no numéricos
                Log.d("EmergAdapter", "Número de teléfono formateado: " + phoneNumber);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                if (ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    Log.d("EmergAdapter", "Permiso CALL_PHONE otorgado");
                    v.getContext().startActivity(intent);
                } else {
                    Log.d("EmergAdapter", "Permiso CALL_PHONE no otorgado");
                    // solicitar permiso CALL_PHONE
                    ActivityCompat.requestPermissions((Activity) v.getContext(), new String[]{Manifest.permission.CALL_PHONE}, 1);
                }
            }
        });

        viewHolder.whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = EmergModel.getWhatsapp().replaceAll("[^0-9]", ""); // formatea el número de teléfono eliminando todos los caracteres no numéricos
                String message = "Turista app, necesito informacion";
                String url = "https://api.whatsapp.com/send?phone=" + phoneNumber + "&text=" + message;;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                v.getContext().startActivity(intent);
            }
        });

        viewHolder.imgwhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = EmergModel.getWhatsapp().replaceAll("[^0-9]", ""); // formatea el número de teléfono eliminando todos los caracteres no numéricos
                String message = "Turista app, necesito informacion";
                String url = "https://api.whatsapp.com/send?phone=" + phoneNumber + "&text=" + message;;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                v.getContext().startActivity(intent);
            }
        });




    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

     View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewemerg,parent,false);
     return  new ViewHolder(v);
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre,telefono,tipo,whatsapp;
        ImageView imgtelf,imgwhatsapp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.txtviewnombre);
            telefono = itemView.findViewById(R.id.txtviewtelefono);
            tipo = itemView.findViewById(R.id.txtviewtipo);
            whatsapp = itemView.findViewById(R.id.txtviewwhatsapp);
            imgtelf = itemView.findViewById(R.id.imgtelef);
            imgwhatsapp = itemView.findViewById(R.id.imgwhat);
        }
    }
}
