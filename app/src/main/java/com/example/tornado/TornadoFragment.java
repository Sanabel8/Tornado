package com.example.tornado;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class TornadoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 ="dishName";
    private static final String ARG_PARAM2  ="dishPrice";
    private static final String ARG_PARAM3 ="dishIngredints";

    // TODO: Rename and change types of parameters
    private String mDishName;
    private String mDishPrice;
    private String mDishIngredints;

    public TornadoFragment(){
        // Required empty public constructor
    }


    public static TornadoFragment newInstance(String mDishName, String mDishPrice ,String mDishIngredints) {
        TornadoFragment fragment = new TornadoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mDishName);
        args.putString(ARG_PARAM2, mDishPrice);
        args.putString(ARG_PARAM3, mDishIngredints);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mDishName = getArguments().getString(ARG_PARAM1);
            mDishPrice = getArguments().getString(ARG_PARAM2);
            mDishIngredints = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dish_item, container, false);
    }

}
