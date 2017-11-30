package com.example.codetribe.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference db;
    private TextView txt1, txt2;
    private Button btn1;
    private Person person;
    private RecyclerView recyclerView;
    private CardView mboni;
    private FirebaseRecyclerAdapter<Person,PersonViewHolder>adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db= FirebaseDatabase.getInstance().getReference();
        db.child("message").push().setValue("hello");

        txt1=(TextView)findViewById(R.id.txt1);
        txt2=(TextView)findViewById(R.id.txt2);
        btn1=(Button) findViewById(R.id.btn1);
        mboni=(CardView)findViewById(R.id.mboni);




        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Person person=new Person((txt1.getText().toString()),(txt2.getText().toString()));


                db.push().setValue(person);




            }
        });

        recyclerView=(RecyclerView)findViewById(R.id.recly);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        adapter=new FirebaseRecyclerAdapter<Person, PersonViewHolder>(Person.class,R.layout.person,PersonViewHolder.class,db) {
            @Override
            protected void populateViewHolder(PersonViewHolder viewHolder, Person model, int position) {

                viewHolder.setName(model.getName());
                viewHolder.setsurn

            }
            private static class PersonViewHolder extends RecyclerView.ViewHolder

        }




    }
}
