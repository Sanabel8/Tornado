package com.example.tornado;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DishDeo {

        @Query("SELECT * FROM dish")
        List<Dish> getAll();

        @Insert
        void insertDish(Dish... dish);

        @Delete
        void delete(Dish dish);

}
