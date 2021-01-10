package com.example.homework311;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
    }

    public void setClick1(View view) {
        Intent intent = new Intent(Register.this,MainActivity.class);
        startActivity(intent);
    }
}