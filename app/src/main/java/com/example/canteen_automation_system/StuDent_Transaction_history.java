package com.example.canteen_automation_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StuDent_Transaction_history extends AppCompatActivity {
    ListView listView;
    ArrayList<Transaction> arrayList = new ArrayList<Transaction>();
    DatabaseReference databaseReference;
    String u_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_dent__transaction_history);

        databaseReference = FirebaseDatabase.getInstance().getReference("Transaction");
        listView = findViewById(R.id.stu_tran_his);
        u_id = getIntent().getStringExtra("stu_l_u_id");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()) {
                    Transaction transaction = data.getValue(Transaction.class);
                    if (u_id.equalsIgnoreCase(transaction.transaction_student_id)) {
                        arrayList.add(transaction);
                        TransactionAdapter transactionAdapter = new TransactionAdapter(StuDent_Transaction_history.this, R.layout.transaction_list_row, arrayList);
                        listView.setAdapter(transactionAdapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}