package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    SignInButton googleBtn;
    private TextView signUp;
    private Button signInButton;

    //button used to be image view
    //check

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUp = (TextView) findViewById(R.id.signUpText);
        signUp.setOnClickListener(this);

        signInButton = (Button) findViewById(R.id.signInButton);
        signInButton.setOnClickListener(this);
    }

    /**
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
        super.onActivityResult(requestCode, resultCode, data);
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
    **/
    void navigateToSecondActivity() {
        finish();
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }


    //this method brings the user to register page when the user clicks on the text "signup"
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signUpText:
                startActivity(new Intent(this,RegisterUser.class));
                break;

            case R.id.signInButton:
                startActivity(new Intent(this,ThirdActivity.class));
                break;
        }
    }
}