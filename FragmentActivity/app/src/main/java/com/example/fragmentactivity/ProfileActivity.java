package com.example.fragmentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.myreusableactivity.R;

public class ProfileActivity extends AppCompatActivity {

    public static final String nim = "191011450014";
    public static final String nama = "Ignasius Riandro Raul";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView tvDataReceived = findViewById(R.id.tv_result_profile);
        String name = getIntent().getStringExtra(nama);
        int age = getIntent().getIntExtra(nim, 0);
        String text = "Nama : " + name + ", Nim : " + age;
        tvDataReceived.setText(text);
    }

}