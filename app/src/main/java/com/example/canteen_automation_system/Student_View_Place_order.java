package com.example.canteen_automation_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Student_View_Place_order extends AppCompatActivity {
    ListView listView;
    ArrayList<Item> arrayList = new ArrayList<Item>();
    DatabaseReference databaseReference;
    String stu_id, stu_u_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__view__place_order);

        databaseReference = FirebaseDatabase.getInstance().getReference("Item");
        listView = findViewById(R.id.student_place_listview);

        stu_id = getIntent().getStringExtra("stu_l_id");
        stu_u_id = getIntent().getStringExtra("stu_l_u_id");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()) {
                    Item item = data.getValue(Item.class);
                    arrayList.add(item);
                    StudentItemListAdapter studentItemListAdapter = new StudentItemListAdapter(Student_View_Place_order.this, R.layout.student_item_list_row, arrayList, stu_id, stu_u_id);
                    listView.setAdapter(studentItemListAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Student_View_Place_order.this, "Database Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Student_View_Place_order.this, Student_DashBoard.class);
        intent.putExtra("stu_l_id", stu_id);
        intent.putExtra("stu_l_u_id", stu_u_id);
        startActivity(intent);
        finish();
    }
}