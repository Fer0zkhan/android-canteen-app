package com.example.canteen_automation_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class Student_login_page extends AppCompatActivity {
    EditText stu_id, pass;
    Button btn;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login_page);

        databaseReference = FirebaseDatabase.getInstance().getReference("Student");
        stu_id = findViewById(R.id.student_email_auth);
        pass = findViewById(R.id.student_pass_auth);

        btn = findViewById(R.id.student_login_btnnnn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String student_id = stu_id.getText().toString().trim();
                        String password = pass.getText().toString().trim();
                        // Student student = snapshot.getValue(Student.class);
                        for (DataSnapshot data : snapshot.getChildren()) {
                            Student student = data.getValue(Student.class);
                            if (!TextUtils.isEmpty(student_id) && !TextUtils.isEmpty(password)) {
                                if (student_id.equalsIgnoreCase(student.student_id) && password.equalsIgnoreCase(student.student_password)) {
                                    Toast.makeText(Student_login_page.this, "Login!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Student_login_page.this, Student_DashBoard.class);
                                    intent.putExtra("stu_l_id", student.student_id);
                                    intent.putExtra("stu_l_u_id", student.id);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(Student_login_page.this, "Not Found Or Incorrect Password!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(Student_login_page.this, "Some Fields Are Missing!", Toast.LENGTH_SHORT).show();
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