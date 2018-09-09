package com.muhammadkunjo.bundled;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    ConstraintLayout logLayout;
    AnimationDrawable animationDrawable;
    private Button signin;
    private Button createacc;
    private Button skip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toast.makeText(this, "Welcome to #FE6601's app!", Toast.LENGTH_LONG).show();
        logLayout = (ConstraintLayout) findViewById(R.id.logLayout);

        animationDrawable = (AnimationDrawable) logLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
    }
    public void gotoRegister(View view) {
        startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
    }
}
