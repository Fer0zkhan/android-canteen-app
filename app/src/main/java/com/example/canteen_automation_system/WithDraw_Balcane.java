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

public class WithDraw_Balcane extends AppCompatActivity {
    EditText stu_search, stu_id, stu_bal, can_search, can_name, can_bal;
    Button stu_withdraw, stu_add, stu_search_btn;
    DatabaseReference databaseReference;
    String uniqueID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_draw__balcane);

        databaseReference = FirebaseDatabase.getInstance().getReference("Student");

        stu_search = findViewById(R.id.w_s_id);
        stu_id = findViewById(R.id.w_stu_id);
        stu_bal = findViewById(R.id.w_stu_bal);
      

        stu_withdraw = findViewById(R.id.w_stu_with_btn);
        stu_add = findViewById(R.id.w_stu_add_btn);
        stu_search_btn = findViewById(R.id.w_stu_search_btn);


        //Student Withdraw balance
        stu_withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String se_id = stu_search.getText().toString().trim();
                if (!TextUtils.isEmpty(se_id)) {
                    if (!TextUtils.isEmpty(stu_bal.getText().toString().trim()) && !TextUtils.isEmpty(stu_id.getText().toString().trim())) {
                        databaseReference.child(uniqueID).child("student_balance").setValue("0");
                        Toast.makeText(WithDraw_Balcane.this, "Withdraw Bal Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(WithDraw_Balcane.this, "Student Fields Are Missing!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(WithDraw_Balcane.this, "Enter Student Unique Id First to withdraw Bal!", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(WithDraw_Balcane.this, "Add Bal Successfully", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(WithDraw_Balcane.this, "Student Fields Are Missing!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(WithDraw_Balcane.this, "Enter Student Unique Id First to Add Bal!", Toast.LENGTH_SHORT).show();
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
                                    uniqueID = student.id;
                                    stu_id.setText(student.getStudent_id());
                                    stu_bal.setText(student.getStudent_balance());
                                } else {
                                    Toast.makeText(WithDraw_Balcane.this, "Not Found", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(WithDraw_Balcane.this, "Enter Id Here To Found Student!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(WithDraw_Balcane.this, "Database error!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}