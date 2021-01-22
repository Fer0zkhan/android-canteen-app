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

public class Student_add_balance extends AppCompatActivity {
    EditText acc, id, amount;
    Button acc_btn;
    String u_id, stuid;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_add_balance);

        databaseReference = FirebaseDatabase.getInstance().getReference("Student");
        u_id = getIntent().getStringExtra("stu_l_u_id");
        stuid = getIntent().getStringExtra("stu_l_id");
        acc = findViewById(R.id.stu_acc_num);
        id = findViewById(R.id.stu_add_id_acc);
        amount = findViewById(R.id.stu_add_bal_acc);

        acc_btn = findViewById(R.id.stu_acc_btn);

        id.setText(u_id);
        acc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data : snapshot.getChildren()) {
                            Student student = data.getValue(Student.class);
                            if (!TextUtils.isEmpty(acc.getText().toString().trim()) && !TextUtils.isEmpty(id.getText().toString().trim()) && !TextUtils.isEmpty(amount.getText().toString().trim())) {
                                int pre_am = Integer.parseInt(student.student_balance);
                                int add_am = Integer.parseInt(amount.getText().toString());
                                int result = pre_am + add_am;
                                databaseReference.child(u_id).child("student_balance").setValue(String.valueOf(result));
                                Toast.makeText(Student_add_balance.this, "Add Amount Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Student_add_balance.this, Student_DashBoard.class);
                                intent.putExtra("stu_l_u_id", u_id);
                                intent.putExtra("stu_l_id", stuid);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(Student_add_balance.this, "Some Fields Are Missing!", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Student_add_balance.this, Student_DashBoard.class);
        intent.putExtra("stu_l_id", stuid);
        intent.putExtra("stu_l_u_id", u_id);
        startActivity(intent);
        finish();
    }
}