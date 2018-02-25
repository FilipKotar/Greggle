package com.example.fatt32.fatt;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
        finish();
    }

    public void guestAct(View view) {
        // Do something in response to Guest button.
        Intent intent = new Intent(this, SchoolSelection.class);
        startActivity(intent);
        finish();
    }

    public void loginAct(View view) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password);
        String emailStr = email.getText().toString();
        String passStr = password.getText().toString();
        final Context thisClass = this;
        // Do something in response to Login button.
        firebaseAuth.signInWithEmailAndPassword(emailStr, passStr)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in passes? Display msg to user.
                            Toast.makeText(thisClass, "Authentication Passed.",
                                    Toast.LENGTH_SHORT).show();
                            // Go to School selection.
                            Intent schoolAct = new Intent(thisClass, navigation.class);
                            startActivity(schoolAct);
                            // Kill off this activity.
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(thisClass, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



}
