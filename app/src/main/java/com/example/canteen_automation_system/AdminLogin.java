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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AdminLogin extends AppCompatActivity {
    Button login_btn;
    EditText email_e, pass;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        firebaseAuth = FirebaseAuth.getInstance();

        login_btn = findViewById(R.id.admin_login_btnnnn);
        email_e = findViewById(R.id.admin_email_auth);
        pass = findViewById(R.id.admin_pass_auth);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            Toast.makeText(AdminLogin.this, "Successfully Sign in", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AdminLogin.this, AdminDashboard.class);
            startActivity(intent);
            finish();
        } else {
            login_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = email_e.getText().toString().trim();
                    String password = pass.getText().toString().trim();

                    if (TextUtils.isEmpty(email)) {
                        Toast.makeText(AdminLogin.this, "Enter Email First", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (TextUtils.isEmpty(password)) {
                        Toast.makeText(AdminLogin.this, "Enter Your Password", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (password.length() < 5) {
                        Toast.makeText(AdminLogin.this, "Password too short, enter minimum 5 characters!", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful()) {
                                Toast.makeText(AdminLogin.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(AdminLogin.this, "Successfully Sign in", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(AdminLogin.this, AdminDashboard.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });
                }
            });
        }

    }
}