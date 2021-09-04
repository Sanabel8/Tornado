package com.example.tornado;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishViewHolder> {

    // create list to bind the data by adapter
    List<Dish> allDishes = new ArrayList<Dish>();


    //create constructor
    public DishAdapter(List<Dish> allDishes){
        this.allDishes = allDishes;
    }
//inner class
    public static class DishViewHolder extends RecyclerView.ViewHolder {

        public Dish dish;
        View itemView;

        public DishViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;

            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(view.getContext(), DetaileForDishe.class);
                intent.putExtra("name",dish.dishName);
                intent.putExtra("price",dish.dishPrice);
                intent.putExtra("ingredients",dish.dishIngredints);
                view.getContext().startActivity(intent);
            });

        }
    }


    //implement method
    @NonNull
    @Override
    public DishAdapter.DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dish_item,parent, false);
        DishViewHolder dishViewHolder = new DishViewHolder(view);
        return dishViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DishAdapter.DishViewHolder holder, int position) {
        holder.dish = allDishes.get(position);

        TextView nameDish = holder.itemView.findViewById(R.id.showName);
        TextView priceDish = holder.itemView.findViewById(R.id.showPrice);

        nameDish.setText(holder.dish.dishName);
        priceDish.setText(holder.dish.dishPrice);

    }

    @Override
    public int getItemCount() {
        return allDishes.size();
    }



}
