package com.example.food;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.food.Models.OrderModel;

import java.util.ArrayList;

public class OrderDB extends SQLiteOpenHelper {
    public static final String ORDER_NAME="ORDER_NAME";
    public static final int ORDER_VERSION=1;

    public OrderDB(@Nullable Context context) {
        super(context, ORDER_NAME, null, ORDER_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table orders " +"(id integer primary key autoincrement," +
                "name text," +
                "price int," +
                "image int," +
                "phone text," +
                "description text," +
                "foodname text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS orders");
        onCreate(db);
    }
    public  boolean add(String name,int price,int image,String phone,String description,String foodName){
        SQLiteDatabase database=getReadableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("price",price);
        cv.put("image",image);
        cv.put("phone",phone);
        cv.put("description",description);
        cv.put("foodName",foodName);
       long id= database.insert("orders",null,cv);
        if(id<=0){
            return false;
        }else{
            return true;
        }
    }
    public ArrayList<OrderModel>  getEveryone(){
        ArrayList<OrderModel> orderModels=new ArrayList<>();
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("Select id,foodname,image,price from orders",null);
        if(cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                OrderModel orderModel = new OrderModel();
                orderModel.setOrderNumber(cursor.getInt(0) + "");
                orderModel.setOrderName(cursor.getString(1));
                orderModel.setOrderImage(cursor.getInt(2));
                orderModel.setPrice(cursor.getInt(3) + "");
                orderModels.add(orderModel);
            }
        }
        cursor.close();
        database.close();
        return orderModels;
    }
}
