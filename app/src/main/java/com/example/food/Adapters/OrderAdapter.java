package com.example.food.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.Models.OrderModel;
import com.example.food.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewHolder>{
    private ArrayList<OrderModel> orderModels;
    private Context context;

    public OrderAdapter(ArrayList<OrderModel> orderModels, Context context) {
        this.orderModels = orderModels;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.order,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final OrderModel orderModel=orderModels.get(position);
        holder.orderImage.setImageResource(orderModel.getOrderImage());
        holder.orderName.setText(orderModel.getOrderName());
        holder.price.setText(orderModel.getPrice());
        holder.orderNumber.setText(orderModel.getOrderNumber());

    }

    @Override
    public int getItemCount() {
        return orderModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView orderImage;
        TextView orderName,price,orderNumber;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            orderImage=itemView.findViewById(R.id.order);
            orderName=itemView.findViewById(R.id.textView);
            price=itemView.findViewById(R.id.tprice);
            orderNumber=itemView.findViewById(R.id.tOrderNumber);

        }
    }
}
