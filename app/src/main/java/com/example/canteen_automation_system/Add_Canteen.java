package com.example.canteen_automation_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Add_Canteen extends AppCompatActivity {
    EditText can_name, can_hand, can_pass, can_phone, can_work, can_address;
    Button can_btn;
    ArrayList<Canteen> arrayList = new ArrayList<Canteen>();
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__canteen);

        databaseReference = FirebaseDatabase.getInstance().getReference("Canteen");

        can_name = findViewById(R.id.can_man_name);
        can_hand = findViewById(R.id.can_handle);
        can_pass = findViewById(R.id.can_pass);
        can_phone = findViewById(R.id.can_mobile);
        can_work = findViewById(R.id.can_num);
        can_address = findViewById(R.id.can_add);
        can_btn = findViewById(R.id.canteen_add_btn);

        can_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCanteen();
            }
        });
    }

    private void addCanteen() {
        String name = can_name.getText().toString().trim();
        String handler = can_hand.getText().toString().trim();
        String password = can_pass.getText().toString().trim();
        String phone = can_phone.getText().toString().trim();
        String work = can_work.getText().toString().trim();
        String address = can_address.getText().toString().trim();

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(handler) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(phone) && !TextUtils.isEmpty(work) && !TextUtils.isEmpty(address)) {

            String id = databaseReference.push().getKey();
            Canteen canteen = new Canteen(id, name, handler, password, phone, work, address);
            databaseReference.child(id).setValue(canteen);

            can_name.setText("");
            can_hand.setText("");
            can_pass.setText("");
            can_phone.setText("");
            can_work.setText("");
            can_address.setText("");

            Toast.makeText(this, "Add New Canteen Successfully!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Some Fields Are Empty Please Fill This Fields!", Toast.LENGTH_SHORT).show();
        }
    }
}