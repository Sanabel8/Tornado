package com.example.tornado;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dish")
public class Dish {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "dish_name")
    public String dishName;

    @ColumnInfo(name = "dish_price")
    public String dishPrice;

    @ColumnInfo(name = "dish_ingredints")
    public String dishIngredints;

    public Dish(String dishName, String dishPrice, String dishIngredints) {
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.dishIngredints = dishIngredints;
    }
}
