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

public class Student_view extends AppCompatActivity {
    ListView listView;
    ArrayList<Student> arrayList = new ArrayList<Student>();
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);


        databaseReference = FirebaseDatabase.getInstance().getReference("Student");
        listView = findViewById(R.id.stu_listview);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Student student = postSnapshot.getValue(Student.class);
                    arrayList.add(student);
                    StudentAdapter studentAdapter = new StudentAdapter(Student_view.this, R.layout.student_list_row, arrayList);
                    listView.setAdapter(studentAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Student_view.this, "Something went wroong!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}