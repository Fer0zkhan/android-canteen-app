package com.example.canteen_automation_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_Student extends AppCompatActivity {
    EditText stu_id, pass, bal;
    Button add;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__student);

        databaseReference = FirebaseDatabase.getInstance().getReference("Student");

        stu_id = findViewById(R.id.stu_id);
        pass = findViewById(R.id.stu_pass);
        bal = findViewById(R.id.stu_bal);

        add = findViewById(R.id.stuadd_btn);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent();
            }
        });
    }

    private void addStudent() {
        String student_id = stu_id.getText().toString().trim();
        String password = pass.getText().toString().trim();
        String balance = bal.getText().toString().trim();

        if (!TextUtils.isEmpty(student_id) && !TextUtils.isEmpty(password)) {
            String id = databaseReference.push().getKey();
            Student student = new Student(id, student_id, password, balance);
            databaseReference.child(id).setValue(student);
            stu_id.setText("");
            pass.setText("");
            bal.setText("");
            Toast.makeText(this, "Student Add Successfully!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
        }
    }
}