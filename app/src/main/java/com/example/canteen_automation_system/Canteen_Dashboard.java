package com.example.canteen_automation_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Canteen_Dashboard extends AppCompatActivity {

    Button add_item, view_item_d, edit_item_d, new_order_d, can_bal, cantran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen__dashboard);

        add_item = findViewById(R.id.add_item_d);
        view_item_d = findViewById(R.id.view_item_d);
        edit_item_d = findViewById(R.id.edit_item_d);
        new_order_d = findViewById(R.id.new_order_d);
        can_bal = findViewById(R.id.canteen_add_bal_d);
        cantran = findViewById(R.id.canteen_transection);


        cantran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Canteen_Dashboard.this,Canteen_Transaction.class);
                startActivity(intent);
            }
        });
        can_bal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Canteen_Dashboard.this,Canteen_add_balance.class);
                startActivity(intent);
            }
        });
        new_order_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Canteen_Dashboard.this,New_Order_list.class);
                startActivity(intent);
            }
        });
        edit_item_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Canteen_Dashboard.this,Edit_Item.class);
                startActivity(intent);
            }
        });
        view_item_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Canteen_Dashboard.this,View_Item.class);
                startActivity(intent);
            }
        });
        add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Canteen_Dashboard.this,Add_Item.class);
                startActivity(intent);
            }
        });
    }
}