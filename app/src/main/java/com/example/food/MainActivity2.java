package com.example.food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.food.Adapters.OrderAdapter;
import com.example.food.Models.OrderModel;
import com.example.food.databinding.ActivityMain2Binding;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        OrderDB orderDB=new OrderDB(this);
        ArrayList<OrderModel> order=orderDB.getEveryone();
        OrderAdapter orderAdapter=new OrderAdapter(order,this);
        binding.recyclerOrder.setAdapter(orderAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerOrder.setLayoutManager(layoutManager);
    }
}