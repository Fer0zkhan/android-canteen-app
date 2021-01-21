package com.example.canteen_automation_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class View_Item extends AppCompatActivity {
    ListView listView;
    ArrayList<Item> arrayList = new ArrayList<Item>();
    DatabaseReference databaseReference;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__item);

        databaseReference = FirebaseDatabase.getInstance().getReference("Item");
        listView = findViewById(R.id.item_listView);
        id = getIntent().getStringExtra("c_login_id");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Item item = postSnapshot.getValue(Item.class);
                    if (id.equalsIgnoreCase(item.canteen_id)) {
                        arrayList.add(item);
                        AddItemAdapter addItemAdapter = new AddItemAdapter(View_Item.this, R.layout.item_list_row, arrayList);
                        listView.setAdapter(addItemAdapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(View_Item.this, "Database Error!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}