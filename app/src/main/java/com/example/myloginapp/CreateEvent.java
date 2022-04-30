package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;

public class CreateEvent extends AppCompatActivity {
    public int numUsers;
    public int duration;
    public int Month;
    public int Day;
    public int Year;

    private EditText enterEmails;
    private EditText durationEntry;
    private EditText dateEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        int numUsers = 0;
        enterEmails = findViewById(R.id.EnterEmails);
        String EmailsEntered = enterEmails.getText().toString();
        for(int i = 0; i<EmailsEntered.length(); i++) {
            if(EmailsEntered.charAt(i)==',') {
                numUsers++;
            }
        }
        numUsers++;
        //needs this last statement because there is 1 more user than commas.
        durationEntry = findViewById(R.id.NumberOfDays);
        duration = Integer.parseInt(durationEntry.getText().toString());
        dateEntry = findViewById(R.id.EnterDate);
        String DateString = dateEntry.getText().toString();
        Month = Integer.parseInt(DateString.substring(0,2));
        Day = Integer.parseInt(DateString.substring(3,5));
        Year = Integer.parseInt(DateString.substring(6,10));

    }
}