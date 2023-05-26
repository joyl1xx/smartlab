package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class kod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kod);
        EditText editText1 = findViewById(R.id.bg);
        EditText editText2 = findViewById(R.id.bg5);
        EditText editText3 = findViewById(R.id.bg6);
        EditText editText4 = findViewById(R.id.bg7);
        ImageButton back = findViewById(R.id.button_back);
        editText4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = "" + editText1.getText() + editText2.getText() + editText3.getText() + editText4.getText();
                Intent intent = new Intent(kod.this,parol.class);
                startActivity(intent);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(kod.this, vhod.class);
                startActivity(intent);
            }
        });
        //Initializing thetextView
        TextView textView;
        textView = findViewById(R.id.hint);

        new CountDownTimer(60000, 1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                //Used for formatting digit to be in 2 digits only
                NumberFormat f = new DecimalFormat("00");

                long sec = (millisUntilFinished/ 1000) % 60;
                textView.setText("Отправить код повторно можно будет через " + f.format(sec) + " секунд");
            }
            //When the ask is over it will print 00:00:00 there
            public void onFinish() {
                textView.setText("Отправить код повторно можно будет через 0 секунд");
            }
        }.start();
    }
}