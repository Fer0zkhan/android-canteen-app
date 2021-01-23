package com.example.canteen_automation_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Student_DashBoard extends AppCompatActivity {
    Button view_order, add_bal, tran, logout, profile;
    String stu_u_id, stu_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__dash_board);

        stu_u_id = getIntent().getStringExtra("stu_l_u_id");
        stu_id = getIntent().getStringExtra("stu_l_id");

        view_order = findViewById(R.id.student_place_order);
        add_bal = findViewById(R.id.student_add_bal);
        tran = findViewById(R.id.student_view_tran);
        logout = findViewById(R.id.student_logout);
        profile = findViewById(R.id.student_profile);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Student_DashBoard.this, Student_Profile.class);
                intent.putExtra("stu_l_u_id", stu_u_id);
                intent.putExtra("stu_l_id", stu_id);
                startActivity(intent);
            }
        });

        view_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Student_DashBoard.this, Student_View_Place_order.class);
                intent.putExtra("stu_l_id", stu_id);
                intent.putExtra("stu_l_u_id", stu_u_id);
                startActivity(intent);
            }
        });
        add_bal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Student_DashBoard.this, Student_add_balance.class);
                intent.putExtra("stu_l_u_id", stu_u_id);
                intent.putExtra("stu_l_id", stu_id);
                startActivity(intent);
            }
        });
        tran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Student_DashBoard.this, StuDent_Transaction_history.class);
                intent.putExtra("stu_l_u_id", stu_u_id);
                intent.putExtra("stu_l_id", stu_id);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Student_DashBoard.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Press Logout Button To logout First!", Toast.LENGTH_SHORT).show();
    }
}