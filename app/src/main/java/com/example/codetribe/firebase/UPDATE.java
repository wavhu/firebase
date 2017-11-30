package com.example.codetribe.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UPDATE extends AppCompatActivity {
    private EditText edt1, edt2;
    private Button btn1;
    private DatabaseReference db,dbwrite;
    String key;
    String name;
    Person person;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Intent intent = this.getIntent();
        String key = intent.getStringExtra("key");

        db = FirebaseDatabase.getInstance().getReference().child("person").child(key);

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Person person = dataSnapshot.getValue(Person.class);
                edt1.setText(person.getName());
                edt2.setText(person.getSurname());


                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void btn1() {
    }

}
    }