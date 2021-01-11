package com.example.canteen_automation_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Student_View_Place_order extends AppCompatActivity {
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
        setContentView(R.layout.activity_student__view__place_order);

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

        item.setItem_id_list("1");
        item.setItem_name_list("Pratha");
        item.setItem_des_list("Pizza Paratha");
        item.setItem_cost_list("200");
        item.setItem_time_list("10 minut");
        item.setItem_can_name("Aplha");
        item.setItem_can_id("123");
        arrayList.add(item);

        arrayList.add(new Item("2", "Pasta", "Cheeze Pasta", "230", "30 minuts", "Alpha", "2233"));
        arrayList.add(new Item("3", "Chicken Roll", "Cheeze Chicken Roll", "230", "30 minuts", "Alpha", "2233"));
        arrayList.add(new Item("4", "Chicken Soup", "Cheeze Pasta", "230", "30 minuts", "Alpha", "2233"));
        arrayList.add(new Item("5", "Fries", "Fries", "230", "30 minuts", "Alpha", "2233"));
        arrayList.add(new Item("6", "Pasta", "Cheeze Pasta", "230", "30 minuts", "Alpha", "2233"));

//        item.setItem_id_list("2");
//        item.setItem_name_list("Pratha");
//        item.setItem_des_list("Pizza Paratha");
//        item.setItem_cost_list("200");
//        item.setItem_time_list("10 minut");
//        item.setItem_can_name("Aplha");
//        item.setItem_can_id("123");
//        arrayList.add(item);
//
//        item.setItem_id_list("3");
//        item.setItem_name_list("Pratha");
//        item.setItem_des_list("Pizza Paratha");
//        item.setItem_cost_list("200");
//        item.setItem_time_list("10 minut");
//        item.setItem_can_name("Aplha");
//        item.setItem_can_id("123");



        listView = findViewById(R.id.student_place_listview);
        AddItemAdapter addItemAdapter = new AddItemAdapter(this, R.layout.item_list_row, arrayList);
        listView.setAdapter(addItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = arrayList.get(position);
                Intent intent = new Intent(Student_View_Place_order.this, Student_Order_Item_select.class);
                intent.putExtra("Item_id", item.getItem_id_list());
                intent.putExtra("Item_Name", item.getItem_name_list());
                intent.putExtra("Item_des", item.getItem_des_list());
                intent.putExtra("Item_cost", item.getItem_cost_list());
                intent.putExtra("Item_time", item.getItem_time_list());
                intent.putExtra("Item_canteen_name", item.getItem_can_name());
                intent.putExtra("item_can_id", item.getItem_can_id());
                startActivity(intent);
            }
        });
    }
}