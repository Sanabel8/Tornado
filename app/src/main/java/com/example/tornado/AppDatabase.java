package com.example.tornado;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Dish.class},version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{
    public abstract DishDeo dishDeo();
}

