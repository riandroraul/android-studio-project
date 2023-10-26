package com.example.intentpertemuan10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URI;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    TextView tvResult;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);
        Button btnMoveWithDataActivity =
                findViewById(R.id.btn_move_activity_data);
        btnMoveWithDataActivity.setOnClickListener(this);
        Button btnMoveWithObject = findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);
        Button btnDialPhone = findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);

        Button btnMoveForResult = findViewById(R.id.btn_move_for_result);
        btnMoveForResult.setOnClickListener(this);
        tvResult = findViewById(R.id.tv_result);

        Button btnMoveWithDataMhs = findViewById(R.id.btn_detail_mahasiswa);
        btnMoveWithDataMhs.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_move_activity)
        {
            Intent move_intent = new Intent(MainActivity.this,
                    MoveActivity.class);
            startActivity(move_intent);
        }else if (v.getId() == R.id.btn_move_activity_data) {
            Intent moveWithDataIntent = new Intent(MainActivity.this,
                    MoveWithDataActivity.class);
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME,
                    "unpam");
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 20);
            startActivity(moveWithDataIntent);
        }else if (v.getId() == R.id.btn_move_activity_object) {
            Person person = new Person();
            person.setName("Universitas Pamulang");
            person.setAge(5);
            person.setEmail("info@unpam.ac.id");
            person.setCity("Tangerang Selatan");
            Intent moveWithObjectIntent = new Intent(MainActivity.this,
                    MoveWithObjectActivity.class);
            moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person);
            startActivity(moveWithObjectIntent);
        }else if (v.getId() == R.id.btn_dial_number) {
            String phoneNumber = "0217412566";
            Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            startActivity(dialPhoneIntent);
        } else if (v.getId() == R.id.btn_move_for_result) {
            Intent moveForResultIntent = new Intent(MainActivity.this,
                    MoveForResultActivity.class);
            startActivityForResult(moveForResultIntent, REQUEST_CODE);
        } else if (v.getId() == R.id.btn_detail_mahasiswa)  {
            Person person2 = new Person();
            person2.setName("Ignasius Riandro Raul");
            person2.setEmail("riandroraul@gmail.com");
            person2.setAge(20);
            person2.setNilaiTugas(90);
            person2.setNilaiUts(87);
            person2.setNilaiUas(85);
            person2.setNim("191011450014");
            person2.setCity("Serang Banten");

            Intent moveWithObjectMhsIntent = new Intent(MainActivity.this,
                    DetailMahasiswaActivity.class);
            moveWithObjectMhsIntent.putExtra(DetailMahasiswaActivity.EXTRA_MAHASISWA, person2);
            startActivity(moveWithObjectMhsIntent);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                int selectedValue =
                        data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }
}