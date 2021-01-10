package com.example.canteen_automation_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class New_Order_list extends AppCompatActivity {
    ListView listView;
    ArrayList order_id = new ArrayList();
    ArrayList order_food_name = new ArrayList();
    ArrayList order_canteen_name = new ArrayList();
    ArrayList order_student_id = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__order_list);

        order_id.add("1");
        order_food_name.add("Pizza Paratha");
        order_canteen_name.add("Alpha Cafe");
        order_student_id.add("F201726455");

        order_id.add("2");
        order_food_name.add("Pizza Paratha");
        order_canteen_name.add("Alpha Cafe");
        order_student_id.add("F201726455");

        order_id.add("3");
        order_food_name.add("Pizza Paratha");
        order_canteen_name.add("Alpha Cafe");
        order_student_id.add("F201726455");

        listView = findViewById(R.id.order_listview);
        Order_listAdapter order_listAdapter = new Order_listAdapter(this, R.layout.order_list_row,order_id,order_food_name,order_canteen_name,order_student_id);
        listView.setAdapter(order_listAdapter);
    }
}