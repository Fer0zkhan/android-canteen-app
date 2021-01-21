package com.example.canteen_automation_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class AdminDashboard extends AppCompatActivity {
    Button add_canteen, edit_can, edit_stu, view_can, stu_view, add_student, withdraw, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        logout = findViewById(R.id.logout);
        add_canteen = findViewById(R.id.add_can);
        add_student = findViewById(R.id.add_stu);
        view_can = findViewById(R.id.view_can);
        stu_view = findViewById(R.id.view_stu);
        edit_can = findViewById(R.id.edit_can);
        edit_stu = findViewById(R.id.edit_stu);
        withdraw = findViewById(R.id.add_balnce);


        withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboard.this, WithDraw_Balcane.class);
                startActivity(intent);
            }
        });
        edit_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboard.this, Edit_Student.class);
                startActivity(intent);
            }
        });
        edit_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboard.this, Edit_Canteen.class);
                startActivity(intent);
            }
        });
        stu_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboard.this, Student_view.class);
                startActivity(intent);
            }
        });
        view_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboard.this, Add_Canteen_View.class);
                startActivity(intent);
            }
        });
        add_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboard.this, Add_Student.class);
                startActivity(intent);
            }
        });

        add_canteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboard.this, Add_Canteen.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminDashboard.this, "Logout", Toast.LENGTH_SHORT).show();
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(AdminDashboard.this, AdminLogin.class);
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