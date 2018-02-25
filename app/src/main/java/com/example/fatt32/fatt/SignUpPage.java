package com.example.fatt32.fatt;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SignUpPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
    }

    public final static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    private EditText email_field, username_field, password_field;
    private FirebaseAuth firebaseAuth;

    private void setUpFields(){
        username_field = (EditText)findViewById(R.id.username_field);
        password_field = (EditText)findViewById(R.id.password);
        email_field = (EditText)findViewById(R.id.email_field);
    }
    private Boolean validate(){
        setUpFields();
        String name = username_field.getText().toString();
        String password = password_field.getText().toString();

        if (name.isEmpty() || password.isEmpty()){
            return false;
        }

        return true;
    }


    public void submitAccount(View view) {
        EditText edit_text   = (EditText)findViewById(R.id.email_field);
        Intent schoolAct = new Intent(this, SchoolSelection.class);
        firebaseAuth = FirebaseAuth.getInstance();
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

            firebaseAuth.createUserWithEmailAndPassword(email, password);

            Toast.makeText(this, "Registration Successful", Toast.LENGTH_LONG).show();
            // Go to School selection.
            startActivity(schoolAct);
            // Kill off this activity.
            finish();
            }
    }
}
