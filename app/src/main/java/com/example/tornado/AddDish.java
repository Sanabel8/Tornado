package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddDish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);


        Button topBtn =(Button) findViewById(R.id.goToMain);
        topBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMain = new Intent(AddDish.this,MainActivity.class);
                startActivity(goToMain);
            }
        });

        Button addDishes = findViewById(R.id.submitBtn);
        addDishes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Add Dish Done !", Toast.LENGTH_SHORT).show();


                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "dishDb").allowMainThreadQueries().build();
                        DishDeo dishDeo = db.dishDeo();


                            TextView dishName = findViewById(R.id.dishNameEntery);
                            String name = dishName.getText().toString();

                            TextView dishPrice = findViewById(R.id.dishPriceEntery);
                            int price = Integer.parseInt(dishPrice.getText().toString());

                            TextView ingredients = findViewById(R.id.ingredientsEntery);
                            String ingreds = ingredients.getText().toString();

                            dishDao.insert(new Dish(name,price,ingreds));

                            Intent goToAddDish = new Intent(AddDishActivity.this, MainActivity.class);
                            startActivity(goToAddDish);
            }
        });


    }
}