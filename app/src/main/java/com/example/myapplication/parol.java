package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class parol extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView17, imageView18, imageView21, imageView22;
    Button button3, button6, button4, button7, button8, button9, button11, button12, button13, button14;

    ArrayList<String> numbers_list = new ArrayList<>();
    String value = "";
    String passCode = "";
    String num_01, num_02, num_03, num_04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parol);
        TextView skip = findViewById(R.id.some_id3);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parol.this, karta.class);
                startActivity(intent);
            }
        });
        initializeComponents();
    }

    private void initializeComponents() {
        imageView17 = findViewById(R.id.imageView17);
        imageView18 = findViewById(R.id.imageView18);
        imageView21 = findViewById(R.id.imageView21);
        imageView22 = findViewById(R.id.imageView22);

        button3 = findViewById(R.id.button3);
        button6 = findViewById(R.id.button6);
        button4 = findViewById(R.id.button4);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button14 = findViewById(R.id.button14);

        button3.setOnClickListener(this);
        button6.setOnClickListener(this);
        button4.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button13.setOnClickListener(this);
        button14.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button3:
                value = value +"1";
                numbers_list.add("1");
                passNumber(numbers_list);
                break;
            case R.id.button6:
                numbers_list.add("2");
                passNumber(numbers_list);
                break;
            case R.id.button4:
                numbers_list.add("3");
                passNumber(numbers_list);
                break;
            case R.id.button7:
                numbers_list.add("4");
                passNumber(numbers_list);
                break;
            case R.id.button8:
                numbers_list.add("5");
                passNumber(numbers_list);
                break;
            case R.id.button9:
                numbers_list.add("6");
                passNumber(numbers_list);
                break;
            case R.id.button11:
                numbers_list.add("7");
                passNumber(numbers_list);
                break;
            case R.id.button12:
                numbers_list.add("8");
                passNumber(numbers_list);
                break;
            case R.id.button13:
                numbers_list.add("9");
                passNumber(numbers_list);
                break;
            case R.id.button14:
                numbers_list.add("0");
                passNumber(numbers_list);
                break;
        }
        if(value.length() == 4){
            Intent intent = new Intent(parol.this, karta.class);
            startActivity(intent);
        }
    }

    private void passNumber(ArrayList<String> numbers_list) {
        if (numbers_list.size() == 0){
            imageView17.setBackgroundResource(R.drawable.oval_grey);
            imageView18.setBackgroundResource(R.drawable.oval_grey);
            imageView21.setBackgroundResource(R.drawable.oval_grey);
            imageView22.setBackgroundResource(R.drawable.oval_grey);
        }else {
            switch (numbers_list.size()){
                case 1:
                    num_01 = numbers_list.get(0);
                    imageView17.setBackgroundResource(R.drawable.oval_blue);
                    break;
                case 2:
                    num_02 = numbers_list.get(1);
                    imageView18.setBackgroundResource(R.drawable.oval_blue);
                    break;
                case 3:
                    num_03 = numbers_list.get(2);
                    imageView21.setBackgroundResource(R.drawable.oval_blue);
                    break;
                case 4:
                    num_04 = numbers_list.get(3);
                    imageView22.setBackgroundResource(R.drawable.oval_blue);
                    passCode = num_01 + num_02 + num_03 + num_04;
                    if (getPassCode().length() == 0){
                        savePassCode(passCode);
                        Intent intent = new Intent(parol.this, karta.class);
                        startActivity(intent);
                    }else {
                        matchPassCode();
                    }
                    break;
            }
        }
    }

    private void matchPassCode() {
        if (getPassCode().equals(passCode)){
            startActivity(new Intent(this,parol.class));
        }else {
            Toast.makeText(this, "Пароль не совпадает", Toast.LENGTH_SHORT).show();
        }
    }

    private SharedPreferences.Editor savePassCode(String passCode){
        SharedPreferences preferences = getSharedPreferences("passcode_pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("passcode",passCode);
        editor.commit();

        return  editor;
    }

    private String getPassCode(){
        SharedPreferences preferences = getSharedPreferences("passcode",Context.MODE_PRIVATE);
        return  preferences.getString("passcode","");
    }
}

