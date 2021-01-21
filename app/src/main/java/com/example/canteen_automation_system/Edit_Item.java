package com.example.canteen_automation_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Edit_Item extends AppCompatActivity {
    EditText s_item, i_name, i_des, i_cost, i_time;
    Button s_btn, e_btn, d_btn;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__item);

        databaseReference = FirebaseDatabase.getInstance().getReference("Item");

        s_item = findViewById(R.id.search_item);

        i_name = findViewById(R.id.item_e_name);
        i_des = findViewById(R.id.item_e_description);
        i_cost = findViewById(R.id.item_e_cost);
        i_time = findViewById(R.id.item_e_time);

        s_btn = findViewById(R.id.item_s_btn);
        e_btn = findViewById(R.id.item_e_btn);
        d_btn = findViewById(R.id.item_d_btn);


        d_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(s_item.getText().toString().trim())) {
                    databaseReference.child(s_item.getText().toString()).removeValue();
                    s_item.setText("");
                    i_name.setText("");
                    i_des.setText("");
                    i_cost.setText("");
                    i_time.setText("");
                    e_btn.setVisibility(View.GONE);
                    d_btn.setVisibility(View.GONE);
                    Toast.makeText(Edit_Item.this, "Item Delete Successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Edit Item
        e_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(s_item.getText().toString().trim())) {
                    if (!TextUtils.isEmpty(i_name.getText().toString().trim())) {
                        databaseReference.child(s_item.getText().toString()).child("item_name_list").setValue(i_name.getText().toString());
                    }
                    if (!TextUtils.isEmpty(i_des.getText().toString().trim())) {
                        databaseReference.child(s_item.getText().toString()).child("item_des_list").setValue(i_des.getText().toString());
                    }
                    if (!TextUtils.isEmpty(i_cost.getText().toString().trim())) {
                        databaseReference.child(s_item.getText().toString()).child("item_cost_list").setValue(i_cost.getText().toString());
                    }
                    if (!TextUtils.isEmpty(i_time.getText().toString().trim())) {
                        databaseReference.child(s_item.getText().toString()).child("item_time_list").setValue(i_time.getText().toString());
                    } else {
                        Toast.makeText(Edit_Item.this, "Some Fields Are Missing!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(Edit_Item.this, "Field Are Missing!", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(Edit_Item.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        //Search Item
        s_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data : snapshot.getChildren()) {
                            Item item = data.getValue(Item.class);
                            if (!TextUtils.isEmpty(s_item.getText().toString().trim())) {
                                if (s_item.getText().toString().equalsIgnoreCase(item.item_id_list)) {
                                    i_name.setText(item.getItem_name_list());
                                    i_des.setText(item.getItem_des_list());
                                    i_cost.setText(item.getItem_cost_list());
                                    i_time.setText(item.getItem_time_list());
                                    e_btn.setVisibility(View.VISIBLE);
                                    d_btn.setVisibility(View.VISIBLE);
                                } else {
                                    Toast.makeText(Edit_Item.this, "Not Found", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(Edit_Item.this, "Search Field Are Empty!", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}