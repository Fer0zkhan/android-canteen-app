package com.example.canteen_automation_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class Edit_Canteen extends AppCompatActivity {
    EditText search, name, hand, pass, phone, work, address;
    Button sh_btn, edit_btn, del_btn;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__canteen);

        databaseReference = FirebaseDatabase.getInstance().getReference("Canteen");

        search = findViewById(R.id.search_canteen);
        name = findViewById(R.id.e_c_name);
        hand = findViewById(R.id.e_h_name);
        pass = findViewById(R.id.e_p_name);
        phone = findViewById(R.id.e_m);
        work = findViewById(R.id.e_w);
        address = findViewById(R.id.e_a);

        sh_btn = findViewById(R.id.canteen_search);
        edit_btn = findViewById(R.id.canteen_edit_btn);
        del_btn = findViewById(R.id.canteen_del_btn);


        del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(search.getText().toString())) {
                    databaseReference.child(search.getText().toString()).removeValue();
                    search.setText("");
                    name.setText("");
                    hand.setText("");
                    pass.setText("");
                    phone.setText("");
                    work.setText("");
                    address.setText("");
                    del_btn.setVisibility(View.GONE);
                    edit_btn.setVisibility(View.GONE);
                    Toast.makeText(Edit_Canteen.this, "Canteen Delete Successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Edit_Canteen.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(search.getText().toString().trim())) {
                    if (!TextUtils.isEmpty(name.getText().toString())) {
                        databaseReference.child(search.getText().toString()).child("canteen_name").setValue(name.getText().toString());
                    }
                    if (!TextUtils.isEmpty(hand.getText().toString())) {
                        databaseReference.child(search.getText().toString()).child("canteen_handler").setValue(hand.getText().toString());
                    }
                    if (!TextUtils.isEmpty(pass.getText().toString())) {
                        databaseReference.child(search.getText().toString()).child("canteen_password").setValue(pass.getText().toString());
                    }
                    if (!TextUtils.isEmpty(phone.getText().toString())) {
                        databaseReference.child(search.getText().toString()).child("canteen_phone").setValue(phone.getText().toString());
                    }
                    if (!TextUtils.isEmpty(work.getText().toString())) {
                        databaseReference.child(search.getText().toString()).child("canteen_work").setValue(work.getText().toString());
                    }
                    if (!TextUtils.isEmpty(address.getText().toString())) {
                        databaseReference.child(search.getText().toString()).child("canteen_address").setValue(address.getText().toString());
                    } else {
                        Toast.makeText(Edit_Canteen.this, "Some Field Are Empty!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Edit_Canteen.this, "Add id for search Canteen!", Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(Edit_Canteen.this, "Updated Successfully", Toast.LENGTH_SHORT).show();

            }
        });

        sh_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data : snapshot.getChildren()) {
                            Canteen canteen = data.getValue(Canteen.class);
                            if (!TextUtils.isEmpty(search.getText().toString().trim())) {
                                if (search.getText().toString().trim().equalsIgnoreCase(canteen.canteen_id)) {
                                    name.setText(canteen.getCanteen_name());
                                    hand.setText(canteen.getCanteen_handler());
                                    pass.setText(canteen.getCanteen_password());
                                    phone.setText(canteen.getCanteen_phone());
                                    work.setText(canteen.getCanteen_work());
                                    address.setText(canteen.getCanteen_address());
                                    Toast.makeText(Edit_Canteen.this, "Find", Toast.LENGTH_SHORT).show();
                                    edit_btn.setVisibility(View.VISIBLE);
                                    del_btn.setVisibility(View.VISIBLE);

                                } else {
                                    Toast.makeText(Edit_Canteen.this, "Not Found", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(Edit_Canteen.this, "Put Id To Search!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(Edit_Canteen.this, "Database Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });

    }
}