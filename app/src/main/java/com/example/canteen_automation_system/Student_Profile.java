package com.example.canteen_automation_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Student_Profile extends AppCompatActivity {
    TextView idd, bal;
    DatabaseReference databaseReference;
    Button back_btn;
    String u_id, stuid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__profile);

        databaseReference = FirebaseDatabase.getInstance().getReference("Student");
        u_id = getIntent().getStringExtra("stu_l_u_id");
        stuid = getIntent().getStringExtra("stu_l_id");
        idd = findViewById(R.id.profile_id);
        bal = findViewById(R.id.profile_bal);
        back_btn = findViewById(R.id.stu_back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Student_Profile.this, Student_DashBoard.class);
                intent.putExtra("stu_l_u_id", u_id);
                intent.putExtra("stu_l_id", stuid);
                startActivity(intent);
                finish();
            }
        });


//        Toast.makeText(this, , Toast.LENGTH_SHORT).show();
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

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Press Go Back Button!", Toast.LENGTH_SHORT).show();
    }
}