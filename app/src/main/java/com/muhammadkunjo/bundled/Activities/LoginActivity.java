package com.muhammadkunjo.bundled.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
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
import com.muhammadkunjo.bundled.Fragments.HomeFragment;
import com.muhammadkunjo.bundled.MainActivity;
import com.muhammadkunjo.bundled.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    ConstraintLayout logLayout;
    AnimationDrawable animationDrawable;
    private Button button_signin;
    private Button button_register;
    private Button button_skip;
    private EditText editTextEmail;
    private EditText editTextPassword;

    //Firebase
    private FirebaseAuth mAuth;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logLayout = (ConstraintLayout) findViewById(R.id.logLayout);

        mAuth = FirebaseAuth.getInstance();

        //if getCurrentUser does not returns null
        if(mAuth.getCurrentUser() != null){
            //that means user is already logged in
            //so close this activity
            finish();

            //and open main activity
            startActivity(new Intent(getApplicationContext(), MainActivity.class));

        animationDrawable = (AnimationDrawable) logLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();

        //link variables to their xml IDs
        button_register = (Button) findViewById(R.id.login_button_register);
        button_signin = (Button) findViewById(R.id.login_button_signin);
        editTextEmail = (EditText) findViewById(R.id.login_email);
        editTextPassword = (EditText) findViewById(R.id.login_password);

        progressDialog = new ProgressDialog(this);

        //onClick listener attachment
        button_register.setOnClickListener(this);
        button_signin.setOnClickListener(this);
        }
    }


    //Login
    private void loginUser(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(email.isEmpty()){
            editTextEmail.setError("Email is required to login");
            editTextEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please enter a valid email address");
            editTextEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        //checking if success
                        if(task.isSuccessful()){
                            finish();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "Login Successful. Welcome!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

        //Displaying a progress dialog
        progressDialog.setMessage("Logging in. Please Wait...");
        progressDialog.show();
    }

    //Go to Register Activity
    public void gotoRegister(View view){
        startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
    }

    @Override
    public void onClick(View view) {
        if(view == button_signin){
            loginUser();
        }

        if(view == button_register){
            finish();
            startActivity(new Intent(this, RegistrationActivity.class));
        }
    }
}
