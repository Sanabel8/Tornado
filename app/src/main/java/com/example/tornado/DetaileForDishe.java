package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetaileForDishe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaile_for_dishe);


        Button goMainPage = (Button) findViewById(R.id.homePage);
        goMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHome = new Intent(DetaileForDishe.this,MainActivity.class);
                startActivity(goToHome);
            }
        });


        Intent intent = getIntent();

        //to set text name
        String name = intent.getExtras().getString("dishName");
        TextView NameForDish = findViewById(R.id.nameOfDish);
        NameForDish.setText(name);

        //to set text price
        String price = intent.getExtras().getString("dishPrice");
        TextView PriceForDish = findViewById(R.id.priceOfDish);
        PriceForDish.setText(price);

        //to set text ingr
        String ingr = intent.getExtras().getString("dishIngredints");
        TextView ingredentsForDish = findViewById(R.id.ingredintsOfDish);
        ingredentsForDish.setText(ingr);

    }
}