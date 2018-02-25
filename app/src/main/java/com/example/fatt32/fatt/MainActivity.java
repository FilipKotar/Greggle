package com.example.fatt32.fatt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class MainActivity extends AppCompatActivity {

    private EditText Email, Password;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void accountCreation(View view) {
        // Do something in response to Account button
        Intent intent = new Intent(this, SignUpPage.class);
        startActivity(intent);
        finish();
    }

    public void guestAct(View view) {
        // Do something in response to Guest button.
        Intent intent = new Intent(this, SchoolSelection.class);
        startActivity(intent);
        finish();
    }

    public void loginAct(View view) {
        // Do something in response to Login button.
        Intent intent = new Intent(this, LoginActivity.class);
        Email = (EditText)findViewById(R.id.enter_username);
        Password = (EditText)findViewById(R.id.enter_pass);

        String email_string = Email.toString().trim();
        String password_string = Password.toString().trim();

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        // if user is already logged in
        if (user != null){
            finish();
            startActivity(intent);
        }

        boolean loginResult = firebaseAuth.signInWithEmailAndPassword(email_string, password_string).isSuccessful();
        if (loginResult){
            Toast.makeText(this, "Login Successful.", Toast.LENGTH_LONG).show();
            startActivity(intent);
            finish();
        }

        else {
            Toast.makeText(this, "Login Failed.", Toast.LENGTH_LONG).show();
        }
    }
}
