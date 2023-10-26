package com.example.tugaspert9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtWidth;
    private EditText edtLength;
    private TextView tvResult;
    private static final String STATE_RESULT = "state_result";

//    @Override
//    protected void onSaveInstanceState(Bundle outState){
//        super.onSaveInstanceState(outState);
//        outState.putString(STATE_RESULT, tvResult.getText().toString());
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtWidth = findViewById(R.id.edt_width);
        edtLength = findViewById(R.id.edt_length);
        tvResult = findViewById(R.id.tv_result);
        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }

    public void hitung_keliling(View view) {
        String inputLength = edtLength.getText().toString().trim();
        String inputWidth = edtWidth.getText().toString().trim();

        boolean isEmptyFields = false;
        if (TextUtils.isEmpty(inputLength)) {
            isEmptyFields = true;
            edtLength.setError("Field panjang tidak boleh kosong");
        }
        if (TextUtils.isEmpty(inputWidth)) {
            isEmptyFields = true;
            edtWidth.setError("Field lebar tidak boleh kosong");
        }
        if (!isEmptyFields) {
            double keliling = 2 * (Double.valueOf(inputLength) + Double.valueOf(inputWidth) );
            tvResult.setText(String.valueOf(keliling));
        }
    }
}