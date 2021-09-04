package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddDish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);


        Button topBtn = (Button) findViewById(R.id.goToMain);
        topBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMain = new Intent(AddDish.this, MainActivity.class);
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


                TextView nameForDish = findViewById(R.id.d_name);
                EditText editNameOfDish = findViewById(R.id.editName);
                String name = nameForDish.getText().toString();


                TextView priceOfDish = findViewById(R.id.d_price);
                EditText EditPriceForDish = findViewById(R.id.editPrice);
                String price = priceOfDish.getText().toString();


                TextView ingredOfDish = findViewById(R.id.ingredientText);
                EditText dishIng = findViewById(R.id.editIng);
                String ingredients = ingredOfDish.getText().toString();


//                Dish insertDishesToDb = new Dish(name, price, ingredients);
//                dishDeo.insertDish(insertDishesToDb);


                Intent goToAddDish = new Intent(AddDish.this, MainActivity.class);
                startActivity(goToAddDish);

            }
        });


    }
}