package com.example.v3rlu.iaeste;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LIST extends AppCompatActivity {


    DatabaseReference databaseReference;

    ProgressDialog progressDialog;

    List<MyDataSetGet> list = new ArrayList<>();

    RecyclerView recyclerView;

    RecyclerViewAdapter adapter ;
    EditText search ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(LIST.this));

        progressDialog = new ProgressDialog(LIST.this);

        progressDialog.setMessage("Loading Data from Firebase Database");

        progressDialog.show();

        databaseReference = FirebaseDatabase.getInstance().getReference("Zones/Zones");

        search=(EditText)findViewById(R.id.search) ;

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    MyDataSetGet studentDetails = dataSnapshot.getValue(MyDataSetGet.class);
                    //Log.d("log hhhhhhhhhhhhhhhhhhh",String.valueOf(studentDetails));

                    list.add(studentDetails);
                }

                adapter = new RecyclerViewAdapter(LIST.this, list);

                recyclerView.setAdapter(adapter);

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();

            }
        });



        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                filter(editable.toString()) ;

            }
        });

    }




    public void filter(String txt){

        ArrayList<MyDataSetGet> Filtredlist =new ArrayList<>() ;
        for (MyDataSetGet item : list) {
            if (item.getCompname().toLowerCase().contains(txt.toLowerCase())) {
                Filtredlist.add(item);
            }
        }

        adapter.filterList(Filtredlist);
    }
}