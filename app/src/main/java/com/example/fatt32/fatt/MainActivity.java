package com.example.fatt32.fatt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /***
     * Goes straight into the second activity (i.e. School page and courses)
     */
    public void guestAction(View firstAct) {
        // Go to School Activity
        Intent toSecAct = new Intent(this, SchoolActivity.class);
        startActivity(toSecAct);
    }
}