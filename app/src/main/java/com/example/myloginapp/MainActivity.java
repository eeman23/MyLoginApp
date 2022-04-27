package com.example.myloginapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//import com.google.android.gms.auth.api.signin.GoogleSignIn;
//import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
//import com.google.android.gms.common.api.ApiException;

public class MainActivity extends AppCompatActivity {
    /*GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    SignInButton googleBtn;
    //button used to be image view
    //check
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* googleBtn = findViewById(R.id.googleButton);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);


        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
*/
        //write data
        Log.d("MainActivity", "in the onCreate method");

        //use lines of code below to access firebase and change path according to context
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        //would use myRef.push().setValue(object) if setting value is being hardcoded
        //push is used to add questions instead of replacing questions
        //would do this for all of the instances of a class using iteration?
        myRef.setValue("Hello, World!");

        //read data
        //listener detects that change has been made
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                //gets the value from the message and
                //is a string class because myRef was set as a string
                String value = dataSnapshot.getValue(String.class);
                Log.d("MainActivity", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("MainActivity", "Failed to read value.", error.toException());
            }
        });

    }

    //when using firebase the class needs a default constructor and getters and setters
    //only need to add data to firebase once and then can use the cloud
/*
    void signIn() {
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);

    }
*/
/*
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

 */
    void navigateToSecondActivity() {
        finish();
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }
}