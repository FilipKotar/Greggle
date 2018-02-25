package com.example.fatt32.fatt;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpPage extends AppCompatActivity {
    private EditText email_field, username_field, password_field;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        FirebaseApp.initializeApp(this);
        firebaseAuth = FirebaseAuth.getInstance();
        email_field = (EditText)findViewById(R.id.email_field);
        username_field = (EditText)findViewById(R.id.username_field);
        password_field = (EditText)findViewById(R.id.password);
    }

    public final static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }


    private Boolean validate(){
        String name = username_field.getText().toString();
        String password = password_field.getText().toString();

        if (name.isEmpty() || password.isEmpty()){
            return false;
        }

        return true;
    }


    public void submitAccount(View view) {
        EditText edit_text = (EditText)findViewById(R.id.email_field);
        // If the email is not valid then,
        if (!isValidEmail(edit_text.getText())) {
            // Client gets "Invalid Email" and has to retry.
            edit_text.setText("Invalid Email");
            // Otherwise,
        }

        else if (!validate()){
            Toast.makeText(this, "Please enter valid inputs", Toast.LENGTH_LONG).show();
        }
        else {
            // upload data to database

            String email = email_field.getText().toString().trim();
            String password = password_field.getText().toString().trim();
            final Context thisClass = this;

            firebaseAuth.createUserWithEmailAndPassword(email, password);
            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                // Sign in passes? Display msg to user.
                                Toast.makeText(thisClass, "Authentication Passed.",
                                        Toast.LENGTH_SHORT).show();
                                // Go to School selection.
                                Intent schoolAct = new Intent(thisClass, SchoolSelection.class);
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

}
