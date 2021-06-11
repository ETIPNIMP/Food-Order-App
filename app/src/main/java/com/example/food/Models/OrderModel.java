package com.example.food.Models;

import android.widget.ImageView;

public class OrderModel {
    int orderImage;
    String orderName,price,orderNumber;

    public OrderModel(int orderImage, String orderName, String price, String orderNumber) {
        this.orderImage = orderImage;
        this.orderName = orderName;
        this.price = price;
        this.orderNumber = orderNumber;
    }

    public OrderModel() {
    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
