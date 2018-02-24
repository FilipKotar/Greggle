package com.example.fatt32.fatt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /***
     *
     */
    public void guestAction() {

    }

    public void accountCreation(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, SignUpPage.class);
        startActivity(intent);
    }
}
