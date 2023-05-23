package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class karta extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.karta);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        startActivity(new Intent(this,parol.class));
    }
}
