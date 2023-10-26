package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainActivity2 {
    private EditText textUTS, textUAS;
    private TextView textNilaiAkhir;
    private Button bHitung, bTutup;
    private int result = 0;
    boolean isEmptyFields = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textUTS = (EditText) findViewById(R.id.editUTS);
        textUAS = (EditText) findViewById(R.id.editUAS);
        textNilaiAkhir = (TextView) findViewById(R.id.editNilaiAkhir);
        bHitung = (Button) findViewById(R.id.buttonHitung);
        bTutup = (Button) findViewById(R.id.buttonTutup);

//        findViewById(R.id.hitungButton).setOnClickListener(this);
//        findViewById(R.id.tutupButton).setOnClickListener(this);

        bHitung.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nilaiUTS = Integer.parseInt(textUTS.getText().toString());
                int nilaiUAS = Integer.parseInt(textUAS.getText().toString());

                int nilai_rata_rata = (nilaiUAS + nilaiUTS) / 2;
                textNilaiAkhir.setText(String.valueOf(nilai_rata_rata));
            }
        }));
        bTutup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }

}