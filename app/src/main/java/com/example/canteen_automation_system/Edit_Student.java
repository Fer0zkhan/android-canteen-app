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

public class Edit_Student extends AppCompatActivity {
    EditText search, stu_id, stu_pass;
    Button search_btn, edit_tn, delete_btn;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__student);

        databaseReference = FirebaseDatabase.getInstance().getReference("Student");

        search = findViewById(R.id.search_student);
        stu_id = findViewById(R.id.student_e_id);
        stu_pass = findViewById(R.id.Student_e_password);

        search_btn = findViewById(R.id.student_search_btn);
        edit_tn = findViewById(R.id.student_edit_btn);
        delete_btn = findViewById(R.id.delete_student_btn);


        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(search.getText().toString().trim())) {
                    databaseReference.child(search.getText().toString()).removeValue();
                    stu_pass.setText("");
                    stu_id.setText("");
                    search.setText("");
                    edit_tn.setVisibility(View.GONE);
                    delete_btn.setVisibility(View.GONE);
                }
            }
        });

        edit_tn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(search.getText().toString().trim())) {
                    if (!TextUtils.isEmpty(stu_id.getText().toString().trim())) {
                        databaseReference.child(search.getText().toString()).child("student_id").setValue(stu_id.getText().toString());
                    }
                    if (!TextUtils.isEmpty(stu_pass.getText().toString().trim())) {
                        databaseReference.child(search.getText().toString()).child("student_password").setValue(stu_pass.getText().toString());
                    } else {
                        Toast.makeText(Edit_Student.this, "Some Fields Are missing!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Edit_Student.this, "Search Id First", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(Edit_Student.this, "Update Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String search_id = search.getText().toString().trim();
                        for (DataSnapshot data : snapshot.getChildren()) {
                            Student student = data.getValue(Student.class);
                            if (!TextUtils.isEmpty(search_id)) {
                                if (search_id.equalsIgnoreCase(student.id)) {
                                    stu_id.setText(student.getStudent_id());
                                    stu_pass.setText(student.getStudent_password());
                                    Toast.makeText(Edit_Student.this, "Find!", Toast.LENGTH_SHORT).show();
                                    edit_tn.setVisibility(View.VISIBLE);
                                    delete_btn.setVisibility(View.VISIBLE);
                                }
                            }
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(Edit_Student.this, "Something went wrong! database", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}