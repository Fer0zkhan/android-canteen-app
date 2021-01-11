package com.example.canteen_automation_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button admin_login, canteen_login, student_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        admin_login = findViewById(R.id.admin_login);
        canteen_login = findViewById(R.id.canteen_login);
        student_login = findViewById(R.id.student_login);


        canteen_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Canteen_Dashboard.class);
                startActivity(intent);
                finish();
            }
        });

        admin_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdminDashboard.class);
                startActivity(intent);
                finish();
            }
        });
        student_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Student_DashBoard.class);
                startActivity(intent);
                finish();
            }
        });
    }
}