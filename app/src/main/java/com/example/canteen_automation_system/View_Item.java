package com.example.canteen_automation_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class View_Item extends AppCompatActivity {
    ListView listView;
    //    ArrayList item_id_list = new ArrayList();
//    ArrayList item_name_list = new ArrayList();
//    ArrayList item_des_list = new ArrayList();
//    ArrayList item_cost_list = new ArrayList();
//    ArrayList item_time_list = new ArrayList();
    ArrayList<Item> arrayList = new ArrayList<Item>();
    Item item = new Item();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__item);

//        item_id_list.add("1");
//        item_name_list.add("Pizza Paratha");
//        item_des_list.add("Pizza Paratha With Cheeze");
//        item_cost_list.add("200");
//        item_time_list.add("20 minuts");
//
//        item_id_list.add("2");
//        item_name_list.add("Pizza Paratha");
//        item_des_list.add("Pizza Paratha With Cheeze");
//        item_cost_list.add("200");
//        item_time_list.add("20 minuts");
//
//        item_id_list.add("3");
//        item_name_list.add("Pizza Paratha");
//        item_des_list.add("Pizza Paratha With Cheeze");
//        item_cost_list.add("200");
//        item_time_list.add("20 minuts");

        item.setItem_id_list("1");
        item.setItem_name_list("Pratha");
        item.setItem_des_list("Pizza Paratha");
        item.setItem_cost_list("200");
        item.setItem_time_list("10 minut");
        item.setItem_can_name("Aplha");
        item.setItem_can_id("123");

        arrayList.add(item);

        listView = findViewById(R.id.item_listView);
        AddItemAdapter addItemAdapter = new AddItemAdapter(this, R.layout.item_list_row, arrayList);
        listView.setAdapter(addItemAdapter);
    }
}