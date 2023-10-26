package com.example.fragmentactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myreusableactivity.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager mFragmentManager = getSupportFragmentManager();
        HomeFragment mHomeFragment = new HomeFragment();
        Fragment fragment =
                mFragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());
        if (!(fragment instanceof HomeFragment)) {
            Log.d("MyFlexibleFragment", "Fragment Name :" +
                    HomeFragment.class.getSimpleName());
            mFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, mHomeFragment, HomeFragment.class.getSimpleName())
                    .commit();

            Button btnProfileActivity = findViewById(R.id.btn_profile);
            btnProfileActivity.setOnClickListener(this);

        }
    }

    public void  onClick(View view) {
        if (view.getId() == R.id.btn_profile) {
            Intent moveWithDataIntent = new Intent(MainActivity.this, ProfileActivity.class);
            moveWithDataIntent.putExtra(ProfileActivity.nama, "Ignasius Riandro Raul");
            moveWithDataIntent.putExtra(ProfileActivity.nim, 20);
            startActivity(moveWithDataIntent);
        }
    }

}