package com.example.fatt32.fatt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void accountCreation(View view) {
        // Do something in response to Account button
        Intent intent = new Intent(this, SignUpPage.class);
        startActivity(intent);
    }

    public void guestAct(View view) {
        // Do something in response to Guest button.
        Intent intent = new Intent(this, SchoolActivity.class);
        startActivity(intent);
    }

    public void loginAct(View view) {
        // Do something in response to Login button.
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
