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

public class Student_Order_Item_select extends AppCompatActivity {
    TextView i_name, i_des, i_cost, i_time, i_c_name;
    String i_stu_id, stu_id, i_c_id;
    Button o_btn;
    DatabaseReference databaseReference, stuDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__order__item_select);

        databaseReference = FirebaseDatabase.getInstance().getReference("Order");
        stuDataBase = FirebaseDatabase.getInstance().getReference("Student");

        i_name = findViewById(R.id.v_f_name);
        i_des = findViewById(R.id.v_d);
        i_cost = findViewById(R.id.v_cost);
        i_time = findViewById(R.id.v_time);
        i_c_name = findViewById(R.id.v_c_name);
        o_btn = findViewById(R.id.v_o_btn);

        i_name.setText(getIntent().getStringExtra("item_name"));
        i_des.setText(getIntent().getStringExtra("item_des"));
        i_cost.setText(getIntent().getStringExtra("item_cost"));
        i_time.setText(getIntent().getStringExtra("item_time"));
        i_c_name.setText(getIntent().getStringExtra("item_can_name"));

        i_stu_id = getIntent().getStringExtra("item_stu_u_id");
        i_c_id = getIntent().getStringExtra("item_can_id");
        stu_id = getIntent().getStringExtra("item_stu_id");

        o_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stuDataBase.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data : snapshot.getChildren()) {
                            Student student = data.getValue(Student.class);
                            int act_am = Integer.parseInt(student.student_balance);
                            int am = Integer.parseInt(getIntent().getStringExtra("item_cost"));
                            if (am <= act_am) {
                                String id = databaseReference.push().getKey();
                                Order order = new Order(id, i_name.getText().toString(), i_cost.getText().toString(), i_c_name.getText().toString(), i_c_id, stu_id, i_stu_id);
                                databaseReference.child(id).setValue(order);
                                int result = act_am - am;
                                stuDataBase.child(i_stu_id).child("student_balance").setValue(String.valueOf(result));
                                Toast.makeText(Student_Order_Item_select.this, "Place Order Successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Student_Order_Item_select.this, Student_DashBoard.class);
                                intent.putExtra("stu_l_u_id", i_stu_id);
                                intent.putExtra("stu_l_id", stu_id);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(Student_Order_Item_select.this, "Balance Low!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Student_Order_Item_select.this, Student_DashBoard.class);
                                intent.putExtra("stu_l_u_id", i_stu_id);
                                intent.putExtra("stu_l_id", stu_id);
                                startActivity(intent);
                                finish();
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
        Intent intent = new Intent(Student_Order_Item_select.this, Student_DashBoard.class);
        intent.putExtra("stu_l_id", stu_id);
        intent.putExtra("stu_l_u_id", i_stu_id);
        startActivity(intent);
        finish();
    }
}