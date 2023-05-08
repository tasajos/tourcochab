package org.tourcocha.chakuy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import org.tourcocha.chakuy.R;
import org.tourcocha.chakuy.model.EmergModel;

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


    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

     View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewemerg,parent,false);
     return  new ViewHolder(v);
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre,telefono,tipo,whatsapp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.txtviewnombre);
            telefono = itemView.findViewById(R.id.txtviewtelefono);
            tipo = itemView.findViewById(R.id.txtviewtipo);
            whatsapp = itemView.findViewById(R.id.txtviewwhatsapp);
        }
    }
}
