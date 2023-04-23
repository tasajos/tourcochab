package org.tourcocha.chakuy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.tourcocha.chakuy.R;
import org.tourcocha.chakuy.UbicacionActivity;
import org.tourcocha.chakuy.model.tour;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.io.File;
import android.util.Log;



public class tourAdapter extends  FirestoreRecyclerAdapter <tour,tourAdapter.ViewHolder>{

    private static final String TAG = "tourAdapter";
    String imageUrl = "https://firebasestorage.googleapis.com/v0/b/tourcocha20.appspot.com/o/images%2F3207e10d-6cd4-49c9-8276-2250fe41f6b9.jpg?alt=media";



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

        // Obtener referencia a Firebase Storage
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef  = null;


        if (tour.getImage() != null && !tour.getImage().isEmpty()) {
            // Obtener referencia de Firebase Storage para la imagen
            storageRef = storage.getReferenceFromUrl(tour.getImage());

            // Cargar imagen con Glide y establecerla en el ImageView correspondiente

            Glide.with(viewHolder.itemView.getContext())
                    .load(storageRef)
                    .into(viewHolder.imageView);


        }




    }


        //viewHolder.txtubicacion.setText(tour.getLocationlat());
        //viewHolder.txtubicacion2.setText(tour.getLocationlong());




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewtour,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,txtfecha,txtdetalle,txttipo,txtorder,txtubicacion,txtubicacion2,txtubicaciontotal;

        ImageView imageView;
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
            imageView = itemView.findViewById(R.id.imageView);

            ImageView imageView = itemView.findViewById(R.id.imageView);

            Picasso.get().load(imageUrl).into(imageView);



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
