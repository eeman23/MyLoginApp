package com.example.myloginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    SignInButton googleBtn;
    private FirebaseAuth mAuth;
    private TextView signUp, welcomeMessage;
    private EditText enterPassword, enterEmail;
    private Button signInButton;
    private ProgressBar progressBar;
    //button used to be image view
    //check

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        signUp = findViewById(R.id.signUpTextMain);
        signUp.setOnClickListener(this);
        signInButton = findViewById(R.id.signInButton);
        signInButton.setOnClickListener(this);

        welcomeMessage = findViewById(R.id.welcomeMessage);
        welcomeMessage.setOnClickListener(this);

        enterPassword= findViewById(R.id.enterPassword);
        enterEmail = findViewById(R.id.enterEmail);

        progressBar = findViewById(R.id.progressBar);

    }


    /*
        googleBtn = findViewById(R.id.googleButton);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

      googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    void signIn() {
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, dahhh);
        if(requestCode == 1000) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e) {
                Log.d("qwerty21", ""+e.getStatus());
                Log.d("qwerty21", ""+e.getStackTrace());
                Log.d("qwerty21", ""+e.getStatusCode());
                Log.d("qwerty21", ""+e.getCause());
                Toast.makeText(getApplicationContext(),"Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }

    }
    */
   /* void navigateToSecondActivity() {
        finish();
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }*/


    //this method brings the user to register page when the user clicks on the text "signup"
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signUpTextMain:
                startActivity(new Intent(this,RegisterUser.class));
                break;

            case R.id.signInButton:
                String email = enterEmail.getText().toString().trim();
                String password = enterPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    enterEmail.setError("Email is required!");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    enterPassword.setError("Password is required!");
                    return;
                }

                if(password.length() < 6){
                    enterPassword.setError("Password must be more than 6 characters!");
                    return;
                }

                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(),ThirdActivity.class));
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Sign In failed!",Toast.LENGTH_LONG);
                        }
                    }
                });
                break;

            case R.id.welcomeMessage:
                startActivity((new Intent (this, MainActivity.class)));
                break;
        }

    }


}