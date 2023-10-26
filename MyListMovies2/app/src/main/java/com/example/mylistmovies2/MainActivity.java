package com.example.mylistmovies2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String title = "Mode List";
    private RecyclerView rvClassMates;
    private ArrayList<ClassMates> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvClassMates = findViewById(R.id.rv_classmates);
        rvClassMates.setHasFixedSize(true);

        list.addAll(getListClassMates());
        showRecyclerList();
        setActionBarTitle(title);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showSelectedClassMate(ClassMates myclass) {
        Toast.makeText(this, "Anda memilih " + myclass.getTitle(),
                Toast.LENGTH_SHORT).show();
    }

    private void showRecyclerList() {
        rvClassMates.setLayoutManager(new LinearLayoutManager(this));
        ListClassMatesAdapter listClassMatesAdapter = new ListClassMatesAdapter(list);
        rvClassMates.setAdapter(listClassMatesAdapter);
        listClassMatesAdapter.setOnItemClickCallback(new ListClassMatesAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(ClassMates data) {
                showSelectedClassMate(data);
            }
        });
    }

    public ArrayList<ClassMates> getListClassMates() {
        String[] dataName = getResources().getStringArray(R.array.data_title);
        String[] dataDescription =
                getResources().getStringArray(R.array.data_genre);
        String[] dataPhoto =
                getResources().getStringArray(R.array.data_photo);
        String[] dataTglRelease = getResources().getStringArray(R.array.data_dateRelease);
        ArrayList<ClassMates> listClassMates = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            ClassMates myclass = new ClassMates();
            myclass.setTitle(dataName[i]);
            myclass.setGenre(dataDescription[i]);
            myclass.setDate_rilis(dataTglRelease[i]);
            myclass.setPhoto(dataPhoto[i]);
            listClassMates.add(myclass);
        }
        return listClassMates;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    private void setMode(int selectedMode) {
        if (selectedMode == R.id.action_list) {
            title = "Mode List";
            showRecyclerList();
        } else if (selectedMode == R.id.action_grid) {
            title = "Mode Grid";
            showRecyclerGrid();
        } else if (selectedMode == R.id.action_cardview) {
            title = "Mode Card";
            showRecyclerCardView();
        }
        setActionBarTitle(title);
    }

    private void showRecyclerGrid(){
        rvClassMates.setLayoutManager(new GridLayoutManager(this, 2));
        GridClassMatesAdapter gridClassMatesAdapter = new GridClassMatesAdapter(list);
        rvClassMates.setAdapter(gridClassMatesAdapter);
        gridClassMatesAdapter .setOnItemClickCallback(new GridClassMatesAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(ClassMates data) {
                showSelectedClassMate(data);
            }
        });
    }

    private void showRecyclerCardView(){
        rvClassMates.setLayoutManager(new LinearLayoutManager(this));
        CardViewClassMateAdapter cardViewClassMateAdapter = new CardViewClassMateAdapter(list);
        rvClassMates.setAdapter(cardViewClassMateAdapter);
    }

}