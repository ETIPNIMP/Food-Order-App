package com.example.food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.food.Adapters.adapters;
import com.example.food.Models.models;
import com.example.food.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<models> list=new ArrayList<>();
        list.add(new models(R.drawable.pizza1,"Pizza","450","Boom Pizza "));
        list.add(new models(R.drawable.pizza,"Pizza","350","Value Deliver Pizza "));
        list.add(new models(R.drawable.burger,"Burger","250","Super Burger "));
        list.add(new models(R.drawable.burger1,"Burger","450","Perfect Burger "));
        list.add(new models(R.drawable.burer2,"Burger","350","Delius Burger "));
        list.add(new models(R.drawable.milk,"Milk Shake","370","Perfect Milk Shake "));
        list.add(new models(R.drawable.shake,"Milk Shake","150"," #Cool "));

        adapters adap=new adapters(list,this);
        binding.recyclerView.setAdapter(adap);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orderClick:
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}