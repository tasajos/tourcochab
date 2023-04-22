package org.tourcocha.chakuy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.tourcocha.chakuy.R;
import org.tourcocha.chakuy.model.tour;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


public class tourAdapter extends  FirestoreRecyclerAdapter <tour,tourAdapter.ViewHolder>{
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public tourAdapter(@NonNull FirestoreRecyclerOptions<tour> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int position, @NonNull tour tour) {

       viewHolder.name.setText(tour.getName());
        viewHolder.txtfecha.setText(tour.getDatef());
        viewHolder.txtdetalle.setText(tour.getDetail());
        viewHolder.txttipo.setText(tour.getType());
        viewHolder.txtorder.setText(tour.getOrder());
        viewHolder.txtubicacion.setText(tour.getLocationlat());
        viewHolder.txtubicacion2.setText(tour.getLocationlong());



    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewtour,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,txtfecha,txtdetalle,txttipo,txtorder,txtubicacion,txtubicacion2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtnombre);
            txtfecha = itemView.findViewById(R.id.txtfecha);
            txtdetalle = itemView.findViewById(R.id.txtdetalle);
            txttipo = itemView.findViewById(R.id.txttipo);
            txtorder = itemView.findViewById(R.id.txtorder);
            txtubicacion = itemView.findViewById(R.id.txtubicacion);
            txtubicacion2 = itemView.findViewById(R.id.txtubicacion2);



        }
    }
}
