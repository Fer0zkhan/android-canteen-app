package com.example.canteen_automation_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Add_Canteen_View extends AppCompatActivity {
    ListView listView;
    ArrayList can_id = new ArrayList();
    ArrayList can_name = new ArrayList();
    ArrayList can_phone = new ArrayList();
    ArrayList can_work = new ArrayList();
    ArrayList can_hand = new ArrayList();
    ArrayList can_address = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__canteen__view);



        can_id.add("1");
        can_name.add("Raza Cafe");
        can_hand.add("Ali Raza");
        can_phone.add("213983918293");
        can_work.add("2");
        can_address.add("Johar Town Lahore");

        can_id.add("2");
        can_name.add("Raza Cafe");
        can_hand.add("Ali Raza");
        can_phone.add("213983918293");
        can_work.add("2");
        can_address.add("Johar Town Lahore");

        can_id.add("3");
        can_name.add("Raza Cafe");
        can_hand.add("Ali Raza");
        can_phone.add("213983918293");
        can_work.add("2");
        can_address.add("Johar Town Lahore");

        listView = findViewById(R.id.canlist);
        CanteenAdapter canteenAdapter = new CanteenAdapter(this, R.layout.canteen_list_row,can_id,can_name,can_hand,can_phone,can_work,can_address);
        listView.setAdapter(canteenAdapter);
    }

}