package com.example.canteen_automation_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Student_Order_Item_select extends AppCompatActivity {
    TextView i_name,i_des,i_cost,i_time,i_c_name;
    String i_id, i_c_id;
    Button o_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__order__item_select);

        i_name = findViewById(R.id.v_f_name);
        i_des = findViewById(R.id.v_d);
        i_cost = findViewById(R.id.v_cost);
        i_time = findViewById(R.id.v_time);
        i_c_name = findViewById(R.id.v_c_name);
        o_btn = findViewById(R.id.v_o_btn);

        i_name.setText(getIntent().getStringExtra("Item_Name"));
        i_des.setText(getIntent().getStringExtra("Item_des"));
        i_cost.setText(getIntent().getStringExtra("Item_cost"));
        i_time.setText(getIntent().getStringExtra("Item_time"));
        i_c_name.setText(getIntent().getStringExtra("Item_canteen_name"));

        i_id = getIntent().getStringExtra("Item_id");
        i_c_id = getIntent().getStringExtra("item_can_id");

    }
}