package org.tourcocha.chakuy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.tourcocha.chakuy.R;
import org.tourcocha.chakuy.UbicacionActivity;
import org.tourcocha.chakuy.model.tour;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;



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
        //viewHolder.txtubicaciontotal.setText(tour.getUbicaciontotal());

        tour tourObj = getItem(position);
        viewHolder.txtubicaciontotal.setText(tourObj.getUbicaciontotal());
        viewHolder.setPosition(position);

        //viewHolder.txtubicacion.setText(tour.getLocationlat());
        //viewHolder.txtubicacion2.setText(tour.getLocationlong());

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewtour,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,txtfecha,txtdetalle,txttipo,txtorder,txtubicacion,txtubicacion2,txtubicaciontotal;
        private int position;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtnombre);
            txtfecha = itemView.findViewById(R.id.txtfecha);
            txtdetalle = itemView.findViewById(R.id.txtdetalle);
            txttipo = itemView.findViewById(R.id.txttipo);
            txtorder = itemView.findViewById(R.id.txtorder);
            //txtubicacion = itemView.findViewById(R.id.txtubicacion);
            //txtubicacion2 = itemView.findViewById(R.id.txtubicacion2);
            txtubicaciontotal = itemView.findViewById(R.id.txtubicacion2);





            txtubicaciontotal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String ubicacion = getItem(position).getUbicaciontotal();
                    String uri = "geo:" + ubicacion + "?z=15&q=" + ubicacion;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    intent.setPackage("com.google.android.apps.maps");
                    v.getContext().startActivity(intent);

                    //Intent intent = new Intent(v.getContext(), UbicacionActivity.class);
                    //*intent.putExtra("ubicacion", tour.getUbicaciontotal());
                    //intent.putExtra("ubicacion", getItem(position).getUbicaciontotal());

                    //v.getContext().startActivity(intent);
                }
            });


        }

        public void setPosition(int position) {
            this.position = position;
        }
    }


}
