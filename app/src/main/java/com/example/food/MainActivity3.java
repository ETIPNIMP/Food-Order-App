package com.example.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food.Models.OrderModel;
import com.example.food.Models.models;
import com.example.food.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {
ActivityMain3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

      final  int image = getIntent().getIntExtra("image", 0);
      final  int price = Integer.parseInt(getIntent().getStringExtra("price"));
     final   String name = getIntent().getStringExtra("name");
       final String description = getIntent().getStringExtra("des");
        binding.imageView.setImageResource(image);
        binding.textView13.setText(String.format("%d", price));
        binding.textView6.setText(name);
        binding.orderDescription.setText(description);

        OrderDB orderDB=new OrderDB(this);
        binding.bOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             boolean success=   orderDB.add(binding.edName.getText().toString(),
                       price,image,binding.edPhone.getText().toString(),description,name );
             if(success){
                 Toast.makeText(MainActivity3.this, "Successful", Toast.LENGTH_SHORT).show();
             }else{
                 Toast.makeText(MainActivity3.this, "Error", Toast.LENGTH_SHORT).show();
             }
            }
        });
    }
}