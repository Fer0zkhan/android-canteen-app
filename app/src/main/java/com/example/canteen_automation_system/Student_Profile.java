package com.example.canteen_automation_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Student_Profile extends AppCompatActivity {
    TextView idd, bal;
    DatabaseReference databaseReference;
    String u_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__profile);

        databaseReference = FirebaseDatabase.getInstance().getReference("Student");
        u_id = getIntent().getStringExtra("stu_l_u_id");
        idd = findViewById(R.id.profile_id);
        bal = findViewById(R.id.profile_bal);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()) {
                    Student student = data.getValue(Student.class);
                    if (u_id.equalsIgnoreCase(student.id)) {
                        idd.setText(student.student_id);
                        bal.setText(student.student_balance);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}