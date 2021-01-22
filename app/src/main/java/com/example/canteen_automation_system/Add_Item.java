package com.example.canteen_automation_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_Item extends AppCompatActivity {
    EditText itemName, description, cost, time;
    Button btn;
    String id, name;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__item);

        databaseReference = FirebaseDatabase.getInstance().getReference("Item");

        id = getIntent().getStringExtra("c_login_id");
        name = getIntent().getStringExtra("c_name");
        itemName = findViewById(R.id.item_name);
        description = findViewById(R.id.item_description);
        cost = findViewById(R.id.item_cost);
        time = findViewById(R.id.item_time);
        btn = findViewById(R.id.canteen_add_item_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
    }

    private void addItem() {
        String i_name = itemName.getText().toString().trim();
        String i_des = description.getText().toString().trim();
        String i_cost = cost.getText().toString().trim();
        String i_time = time.getText().toString().trim();


        if (!TextUtils.isEmpty(i_name) && !TextUtils.isEmpty(i_des) && !TextUtils.isEmpty(i_cost) && !TextUtils.isEmpty(i_time)) {
            String unique_id = databaseReference.push().getKey();
            Item item = new Item(unique_id, i_name, i_des, i_cost, i_time, name, id);
            databaseReference.child(unique_id).setValue(item);
            itemName.setText("");
            description.setText("");
            cost.setText("");
            time.setText("");
            Toast.makeText(this, "Add Item Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Add_Item.this, Canteen_Dashboard.class);
            intent.putExtra("Canteen_id", id);
            intent.putExtra("canteen_name", name);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Some Fields Are Missing!", Toast.LENGTH_SHORT).show();
        }
    }
}