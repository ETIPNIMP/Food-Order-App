package com.example.food.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.MainActivity3;
import com.example.food.Models.models;
import com.example.food.R;

import java.util.ArrayList;

public class adapters extends RecyclerView.Adapter<adapters.viewHolder> {
    private ArrayList<models> list;

    public adapters(ArrayList<models> list, Context context) {
        this.list = list;
        this.context = context;
    }

    private Context context;

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.simple_food,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final models mod=list.get(position);
        holder.foodImage.setImageResource(mod.getImage());
        holder.name.setText(mod.getName());
        holder.price.setText(mod.getPrice());
        holder.description.setText(mod.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,MainActivity3.class);
                intent.putExtra("image",mod.getImage());
                intent.putExtra("name",mod.getName());
                intent.putExtra("price",mod.getPrice());
                intent.putExtra("description",mod.getDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView foodImage;
        TextView name,price,description;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage=itemView.findViewById(R.id.food);
            name=itemView.findViewById(R.id.tName);
            price=itemView.findViewById(R.id.textView3);
            description=itemView.findViewById(R.id.textView4);

        }
    }
}
