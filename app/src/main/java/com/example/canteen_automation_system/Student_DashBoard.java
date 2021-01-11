package com.example.canteen_automation_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Student_DashBoard extends AppCompatActivity {
    Button view_order, add_bal, tran, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__dash_board);

        view_order = findViewById(R.id.student_place_order);
        add_bal = findViewById(R.id.student_add_bal);
        tran = findViewById(R.id.student_view_tran);
        logout = findViewById(R.id.student_logout);

        view_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Student_DashBoard.this, Student_View_Place_order.class);
                startActivity(intent);
            }
        });
        add_bal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Student_DashBoard.this, Student_add_balance.class);
                startActivity(intent);
            }
        });
        tran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Student_DashBoard.this, StuDent_Transaction_history.class);
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
}