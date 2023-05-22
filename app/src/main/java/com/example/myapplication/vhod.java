package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class vhod extends AppCompatActivity {
    String email = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vhod);
        Button next = findViewById(R.id.button213);
        EditText emailValidate = findViewById(R.id.editText12);
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        //String email = emailValidate.getText().toString().trim();
        next.setEnabled(false);
        emailValidate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                next.setEnabled(false);
               next.setBackgroundResource(R.drawable.next_false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                next.setEnabled(false);
              next.setBackgroundResource(R.drawable.next_false);
            }

            @Override
            public void afterTextChanged(Editable s) {
                email = emailValidate.getText().toString().trim();
                if (email.matches(emailPattern) && s.length() > 0) {
                    next.setEnabled(true);
                   next.setBackgroundResource(R.drawable.button_main);
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(vhod.this, kod.class);
                            startActivity(intent);
                        }
                    });
                } else {
                    next.setEnabled(false);
                   next.setBackgroundResource(R.drawable.next_false);

                }
            }
        });
    }
}