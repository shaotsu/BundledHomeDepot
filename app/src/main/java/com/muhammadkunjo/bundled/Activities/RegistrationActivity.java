package com.muhammadkunjo.bundled.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.muhammadkunjo.bundled.MainActivity;
import com.muhammadkunjo.bundled.R;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText editTextEmail;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextConfPassword;
    private Button button_register;

    //Firebase
    private FirebaseAuth mAuth;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();

        //if getCurrentUser does not returns null
        if (mAuth.getCurrentUser() != null) {
            //that means user is already logged in
            //so close this activity
            finish();

            //and open main activity
            startActivity(new Intent(getApplicationContext(), MainActivity.class));

            //link variables to their xml IDs
            editTextEmail = findViewById(R.id.register_email);
            editTextUsername = findViewById(R.id.register_username);
            editTextPassword = findViewById(R.id.register_password);
            editTextConfPassword = findViewById(R.id.register_conf_password);
            button_register = findViewById(R.id.register_button);

            progressDialog = new ProgressDialog(this);

            //onClick listener attachment
            button_register.setOnClickListener(this);
        }
    }



    //Register
    private void registerUser() {
        String email = editTextEmail.getText().toString().trim();
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString();
        String conf_password = editTextConfPassword.getText().toString();

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Please enter a valid email address");
            editTextEmail.requestFocus();
            return;
        }
        if (username.isEmpty()) {
            editTextUsername.setError("Username is required");
            editTextUsername.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            editTextPassword.setError("Minimum length of password is 6 characters");
            editTextPassword.requestFocus();
            return;
        }
        if (!password.equals(conf_password)) {
            editTextConfPassword.setError("Passwords didn't match, please re-enter");
            editTextConfPassword.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        //checking if success
                        if (task.isSuccessful()) {
                            startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                            Toast.makeText(getApplicationContext(), "Registration Successful.", Toast.LENGTH_SHORT).show();
                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(getApplicationContext(), "This email is already registered. Please use another.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }
    @Override
    public void onClick(View view) {
        if(view == button_register){
            registerUser();
        }
    }
}
