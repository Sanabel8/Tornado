package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Button goMainPage = (Button) findViewById(R.id.goHomeP);
        goMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHome = new Intent(Menu.this,MainActivity.class);
                startActivity(goToHome);
            }
        });


        //insted of added data we will store it in data base  and we will use list to store it
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "dishDb").allowMainThreadQueries().build();

        DishDeo dishDeo = db.dishDeo();
        List<Dish> dishes = dishDeo.getAll();

        // get the recycler view
        RecyclerView dishRecyclerView = findViewById(R.id.showingDetailes);
        // set a layout manager for this view
        dishRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // set the adapter for this recyclerView
        dishRecyclerView.setAdapter(new DishAdapter(dishes));



    }
}