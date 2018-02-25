package com.example.fatt32.fatt;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ask_question extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_question2);
    }

    public void askQuestion(View view) {
        // Get data from name.
        EditText question = (EditText) findViewById(R.id.question);
        // Get String version of Question.
        String questionStr = question.getText().toString();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue(questionStr);
        // Get the database

        // Go back to question.
        Intent intent = new Intent(this, navigation.class);
        startActivity(intent);
    }
}
