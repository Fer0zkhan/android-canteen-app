package com.example.canteen_automation_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class New_Order_list extends AppCompatActivity {
    ListView listView;
    ArrayList<Order> arrayList = new ArrayList<Order>();
    DatabaseReference databaseReference;
    String id, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__order_list);

        databaseReference = FirebaseDatabase.getInstance().getReference("Order");
        listView = findViewById(R.id.order_listview);

        id = getIntent().getStringExtra("c_login_id");
        name = getIntent().getStringExtra("c_name");

        Toast.makeText(this, id + name, Toast.LENGTH_SHORT).show();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()) {
                    Order order = data.getValue(Order.class);
                    if (name.equalsIgnoreCase(order.getOrder_canteen_name()) || id.equalsIgnoreCase(order.getOrder_canteen_id())) {
                        arrayList.add(order);
                        Order_listAdapter order_listAdapter = new Order_listAdapter(New_Order_list.this, R.layout.order_list_row, arrayList);
                        listView.setAdapter(order_listAdapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(New_Order_list.this, Canteen_Dashboard.class);
        intent.putExtra("Canteen_id", id);
        intent.putExtra("canteen_name", name);
        startActivity(intent);
        finish();
    }
}