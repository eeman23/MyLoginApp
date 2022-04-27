package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class CrossCheck extends AppCompatActivity {
    public CheckBox checkBox;
    public TimeFrame block;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_check);

        checkBox = (CheckBox) findViewById(R.id.checkBox2);
        checkBox.setOnClickListener((View.OnClickListener) this);

        block = new TimeFrame(4,23,2022,12,54);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.checkBox2:
                block.setAvailable();
                break;
        }
    }
}