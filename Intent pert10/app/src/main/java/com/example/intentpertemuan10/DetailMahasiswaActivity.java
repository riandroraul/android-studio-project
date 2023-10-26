package com.example.intentpertemuan10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailMahasiswaActivity extends AppCompatActivity {

    public static final String EXTRA_MAHASISWA = "extra_mhs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);
        TextView tvObject = findViewById(R.id.hasil_data_mahasiswa);

        Person person2 = getIntent().getParcelableExtra(EXTRA_MAHASISWA);
        String text = "Name : " + person2.getName() +", \nNim : "+ person2.getNim() + ",\nEmail : " +
                person2.getEmail() + ",\nAge : " + person2.getAge() + ", \nAlamat : "+person2.getCity() + ",\nNilai Tugas : " +
                person2.getNilaiTugas() + ",\nNilai UTS : "+ person2.getNilaiUts() + ",\nNilai UAS : "+ person2.getNilaiUas();
        tvObject.setText(text);
    }
}