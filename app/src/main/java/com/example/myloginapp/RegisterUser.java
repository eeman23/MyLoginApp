package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private TextView welcomeMessage;
    private EditText enterEmail, enterPassword, enterUserName;
    private Button signInButton;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);


        signInButton = (Button) findViewById(R.id.signInButton);
        signInButton.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

        welcomeMessage = findViewById(R.id.welcomeMessage);
        welcomeMessage.setOnClickListener(this);

        enterEmail = findViewById(R.id.enterEmail);
        enterPassword= findViewById(R.id.enterPassword);
        enterUserName = findViewById(R.id.enterUserName);

        progressBar = findViewById(R.id.progressBar);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.signInButton:
                startActivity(new Intent(this,ThirdActivity.class));
                break;

            case R.id.welcomeMessage:
                startActivity((new Intent (this, MainActivity.class)));
                break;

        }
    }

    private void signUpUser() {
        String email = enterEmail.getText().toString().trim();
        String password = enterPassword.getText().toString().trim();
        String username = enterUserName.getText().toString().trim();

        if(email.isEmpty()){
            enterEmail.setError("Email is not valid!");
            enterEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
           enterPassword.setError("Password is empty!");
           enterPassword.requestFocus();
            return;
        }

        if(username.isEmpty()){
            enterUserName.setError("Username is empty!");
            enterUserName.requestFocus();
            return;
        }

        if(password.length() < 3){
            enterPassword.setError("Password needs to have more than 3 characters!");
            enterPassword.requestFocus();
            return;
        }
    }
}