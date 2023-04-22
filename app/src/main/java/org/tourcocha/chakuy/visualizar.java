package org.tourcocha.chakuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import org.tourcocha.chakuy.adapter.tourAdapter;
import org.tourcocha.chakuy.model.tour;

public class visualizar extends AppCompatActivity {

    RecyclerView mRecycler;
    tourAdapter mAdapter;
    FirebaseFirestore mFirestore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        this.setTitle("Lugares");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mFirestore = FirebaseFirestore.getInstance();
        mRecycler = findViewById(R.id.recyclerviwe2);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        Query query = mFirestore.collection("tourdb");

        FirestoreRecyclerOptions<tour> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<tour>().setQuery(query,tour.class).build();

        mAdapter = new tourAdapter(firestoreRecyclerOptions);
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);


    }

    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAdapter.startListening();

    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

}