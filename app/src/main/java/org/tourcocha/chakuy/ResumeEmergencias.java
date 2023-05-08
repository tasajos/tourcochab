package org.tourcocha.chakuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import org.tourcocha.chakuy.adapter.EmergAdapter;
import org.tourcocha.chakuy.model.EmergModel;

public class ResumeEmergencias extends AppCompatActivity {

    RecyclerView mRecycler;
    EmergAdapter mAdapter;
    FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_emergencias);

        mFirestore = FirebaseFirestore.getInstance();
        mRecycler =  findViewById(R.id.ReciclerViewEmerg);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        Query query = mFirestore.collection("emergencias");

        FirestoreRecyclerOptions<EmergModel> firestoreRecyclerOptions =

                new FirestoreRecyclerOptions.Builder<EmergModel>().setQuery(query,EmergModel.class).build();

        mAdapter = new EmergAdapter(firestoreRecyclerOptions);
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
        mAdapter.stopListening();

    }
}