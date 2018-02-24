package com.example.fatt32.fatt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;

public class SignUpPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
    }

    public final static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public void submitAccount(View view) {
        EditText edit_text   = (EditText)findViewById(R.id.email_field);
        Intent schoolAct = new Intent(this, SchoolActivity.class);
        // If the email is not valid then,
        if (!isValidEmail(edit_text.getText())) {
            // Client gets "Invalid Email" and has to retry.
            edit_text.setText("Invalid Email");
            // Otherwise,
        } else {
            // Go to School selection.
            startActivity(schoolAct);
            // Kill off this activity.
            finish();
            }
    }
}
