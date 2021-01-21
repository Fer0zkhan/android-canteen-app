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

public class Canteen_Login_page extends AppCompatActivity {
    EditText id, pass;
    Button login;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen__login_page);

        databaseReference = FirebaseDatabase.getInstance().getReference("Canteen");

        id = findViewById(R.id.canteen_login_auth);
        pass = findViewById(R.id.canteen_pass_auth);
        login = findViewById(R.id.canteen_login_btnnnn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data : snapshot.getChildren()) {
                            Canteen canteen = data.getValue(Canteen.class);
                            String c_id = id.getText().toString().trim();
                            String c_pass = pass.getText().toString().trim();
                            if (!TextUtils.isEmpty(c_id) && !TextUtils.isEmpty(c_pass)) {
                                if (c_id.equalsIgnoreCase(canteen.canteen_name) && c_pass.equalsIgnoreCase(canteen.canteen_password)) {
//                                    Toast.makeText(Canteen_Login_page.this, , Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Canteen_Login_page.this, Canteen_Dashboard.class);
                                    intent.putExtra("Canteen_id", canteen.canteen_id);
                                    intent.putExtra("canteen_name", canteen.canteen_name);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(Canteen_Login_page.this, "Wrong Name Or Password!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(Canteen_Login_page.this, "Some Fields Are Missing!", Toast.LENGTH_SHORT).show();
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