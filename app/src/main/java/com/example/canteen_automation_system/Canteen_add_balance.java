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

public class Canteen_add_balance extends AppCompatActivity {
    EditText stu_search, stu_id, stu_bal;
    Button stu_withdraw, stu_add, stu_search_btn;
    DatabaseReference databaseReference;
    String uniqueID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen_add_balance);
        databaseReference = FirebaseDatabase.getInstance().getReference("Student");

        stu_search = findViewById(R.id.can_add_bal_search);
        stu_id = findViewById(R.id.can_add_stu_id);
        stu_bal = findViewById(R.id.can_add_stu_bal);

        stu_withdraw = findViewById(R.id.can_add_w_btn);
        stu_add = findViewById(R.id.can_add_s_btn);
        stu_search_btn = findViewById(R.id.can_add_bal_s_btn);

        //Student Withdraw balance
        stu_withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String se_id = stu_search.getText().toString().trim();
                if (!TextUtils.isEmpty(se_id)) {
                    if (!TextUtils.isEmpty(stu_bal.getText().toString().trim()) && !TextUtils.isEmpty(stu_id.getText().toString().trim())) {
                        databaseReference.child(uniqueID).child("student_balance").setValue("0");
                        Toast.makeText(Canteen_add_balance.this, "Withdraw Bal Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Canteen_add_balance.this, "Student Fields Are Missing!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Canteen_add_balance.this, "Enter Student Unique Id First to withdraw Bal!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Add Student Balance
        stu_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String se_id = stu_search.getText().toString().trim();
                if (!TextUtils.isEmpty(se_id)) {
                    if (!TextUtils.isEmpty(stu_bal.getText().toString().trim()) && !TextUtils.isEmpty(stu_id.getText().toString().trim())) {
                        databaseReference.child(uniqueID).child("student_balance").setValue(stu_bal.getText().toString());
                        Toast.makeText(Canteen_add_balance.this, "Add Bal Successfully", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(Canteen_add_balance.this, "Student Fields Are Missing!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Canteen_add_balance.this, "Enter Student Unique Id First to Add Bal!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Search Student with their unique id
        stu_search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data : snapshot.getChildren()) {
                            String search_stu_id = stu_search.getText().toString().trim();
                            Student student = data.getValue(Student.class);
                            if (!TextUtils.isEmpty(search_stu_id)) {
                                if (search_stu_id.equalsIgnoreCase(student.student_id)) {
//                                    Toast.makeText(Canteen_add_balance.this, student.id, Toast.LENGTH_SHORT).show();
                                    uniqueID = student.id;
                                    stu_id.setText(student.getStudent_id());
                                    stu_bal.setText(student.getStudent_balance());
                                } else {
                                    Toast.makeText(Canteen_add_balance.this, "Not Found", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(Canteen_add_balance.this, "Enter Id Here To Found Student!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(Canteen_add_balance.this, "Database error!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}